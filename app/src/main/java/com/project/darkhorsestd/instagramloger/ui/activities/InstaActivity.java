package com.project.darkhorsestd.instagramloger.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.instagram.instagramapi.activities.InstagramAuthActivity;
import com.instagram.instagramapi.engine.InstagramEngine;
import com.instagram.instagramapi.engine.InstagramKitConstants;
import com.instagram.instagramapi.exceptions.InstagramException;
import com.instagram.instagramapi.interfaces.InstagramLoginCallbackListener;
import com.instagram.instagramapi.objects.IGSession;
import com.instagram.instagramapi.utils.InstagramKitLoginScope;
import com.instagram.instagramapi.widgets.InstagramLoginButton;
import com.project.darkhorsestd.instagramloger.R;
import com.project.darkhorsestd.instagramloger.data.managers.DataManager;
import com.project.darkhorsestd.instagramloger.data.managers.PreferencesManager;
import com.project.darkhorsestd.instagramloger.data.network.res.UserInfoRes;
import com.project.darkhorsestd.instagramloger.utils.RoundedAvatarDrawable;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstaActivity extends AppCompatActivity {

    private static PreferencesManager sPreferencesManager = DataManager.getInstance().getPreferencesManager();
    private DataManager mDataManager = DataManager.getInstance();
    private Button mLoginButton;
    private DrawerLayout mNavigationDrawer;
    private NavigationView mNavigationView;
    private CoordinatorLayout mCoordinatorLayout;
    private TextView mFollowedByView, mUserName, mFullName;
    private ImageView mDrawerUserAvatar;




    String[] scopes = {InstagramKitLoginScope.BASIC};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insta);

        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        View header = mNavigationView.getHeaderView(0);
        mLoginButton = (Button) header.findViewById(R.id.loginButton);
        mLoginButton.setOnClickListener(loginOnClickListener);
        mFollowedByView = (TextView) findViewById(R.id.up_second_textview);
        mUserName = (TextView) header.findViewById(R.id.user_name);
        mFullName = (TextView) header.findViewById(R.id.user_fullname);
        mDrawerUserAvatar = (ImageView) header.findViewById(R.id.profile_image);


    }


    View.OnClickListener loginOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(InstaActivity.this, InstagramAuthActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);

            intent.putExtra(InstagramEngine.TYPE, InstagramEngine.TYPE_LOGIN);
            intent.putExtra(InstagramEngine.SCOPE, scopes);

            startActivityForResult(intent, InstagramEngine.REQUEST_CODE_LOGIN);
        }
    };


    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case InstagramEngine.REQUEST_CODE_LOGIN:

                if (resultCode == RESULT_OK) {

                    Bundle bundle = data.getExtras();

                    if (bundle.containsKey(InstagramKitConstants.kSessionKey)) {

                        IGSession session = (IGSession) bundle.getSerializable(InstagramKitConstants.kSessionKey);

                        assert session != null;
                        sPreferencesManager.saveAuthToken(session);

                        Toast.makeText(InstaActivity.this, "Logged" + sPreferencesManager.getAuthToken(),
                                Toast.LENGTH_LONG).show();

                        mDataManager.userInfo(sPreferencesManager.getAuthToken()).enqueue(new Callback<UserInfoRes>() {
                            @Override
                            public void onResponse(Call<UserInfoRes> call, Response<UserInfoRes> response) {
                                if(response.isSuccessful()){
                                    loginSuccess(response.body());
                                    mFollowedByView.setText(String.valueOf(response.body().getData().getCounts().getFollowedBy()));
                                    mFullName.setText(response.body().getData().getFullName());
                                    mUserName.setText(response.body().getData().getUsername());
                                    insertDrawerAvatar(Uri.parse(response.body().getData().getProfilePicture()));

                                }
                            }

                            @Override
                            public void onFailure(Call<UserInfoRes> call, Throwable t) {

                            }
                        });


                    }
                }
                break;
            case InstagramEngine.REQUEST_CODE_LOGOUT:
                if (resultCode == RESULT_OK) {

                    Toast.makeText(InstaActivity.this, "Logged Out Successfully.",
                            Toast.LENGTH_LONG).show();
                }
            default:
                break;
        }

    }
    private void insertDrawerAvatar(Uri selectedImage) {
        Picasso.with(this)
                .load(selectedImage)
                .fit()
                .centerCrop()
                .transform(new RoundedAvatarDrawable())
                .placeholder(R.drawable.avatar_bg)
                .into(mDrawerUserAvatar);
    }

    public void genericClickListener(View v){
        switch(v.getId()){
            case R.id.logout:
                InstagramEngine.getInstance(InstaActivity.this).logout(InstaActivity.this, InstagramEngine.REQUEST_CODE_LOGOUT);
        }
    }

    //Обработываем успешную авторизацию пользователя

    private void loginSuccess(UserInfoRes userInfoRes){
        sPreferencesManager.saveUserPhoto(Uri.parse(userInfoRes.getData().getProfilePicture()));
    }
}
