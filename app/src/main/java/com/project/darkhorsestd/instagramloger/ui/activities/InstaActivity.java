package com.project.darkhorsestd.instagramloger.ui.activities;

import android.content.Intent;
import android.net.Uri;

import android.support.design.widget.NavigationView;
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
import com.instagram.instagramapi.objects.IGSession;
import com.instagram.instagramapi.utils.InstagramKitLoginScope;
import com.project.darkhorsestd.instagramloger.R;
import com.project.darkhorsestd.instagramloger.data.managers.DataManager;
import com.project.darkhorsestd.instagramloger.data.managers.PreferencesManager;
import com.project.darkhorsestd.instagramloger.data.network.res.Data;
import com.project.darkhorsestd.instagramloger.data.network.res.DataItem;
import com.project.darkhorsestd.instagramloger.data.network.res.Location;
import com.project.darkhorsestd.instagramloger.data.network.res.UserInfoRes;
import com.project.darkhorsestd.instagramloger.data.network.res.UserMediaRes;
import com.project.darkhorsestd.instagramloger.utils.RoundedAvatarDrawable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstaActivity extends AppCompatActivity {
    // Google api key AIzaSyBoXJfaWV2QjLnt5SFcTWq1zaScG2JIKHY
    private PreferencesManager mPreferencesManager = DataManager.getInstance().getPreferencesManager();
    private DataManager mDataManager = DataManager.getInstance();
    private TextView mUserName, mFullName;
    private ImageView mDrawerUserAvatar;

    @BindView(R.id.navigation_drawer)
    DrawerLayout mNavigationDrawer;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.up_second_textview)
    TextView mFollowedByView;
    @BindView(R.id.up_first_textview)
    TextView mFollowed;
    @BindView(R.id.user_bio)
    TextView mUserBio;
    @BindView(R.id.user_website)
    TextView mUserWebsite;
    @BindView(R.id.tag)
    TextView mTags;
    @BindView(R.id.photos_location)
    Button mMapButton;


    String[] scopes = {
            InstagramKitLoginScope.BASIC,
            InstagramKitLoginScope.COMMENTS,
            InstagramKitLoginScope.LIKES,
            InstagramKitLoginScope.RELATIONSHIP,
            InstagramKitLoginScope.PUBLIC_ACCESS,
            InstagramKitLoginScope.FOLLOWER_LIST};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insta);
        ButterKnife.bind(this);

        View header = mNavigationView.getHeaderView(0);
        Button loginButton = (Button) header.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(loginOnClickListener);
        mUserName = (TextView) header.findViewById(R.id.user_name);
        mFullName = (TextView) header.findViewById(R.id.user_fullname);
        mDrawerUserAvatar = (ImageView) header.findViewById(R.id.profile_image);

        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InstaActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
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
    protected void onActivityResult(final int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case InstagramEngine.REQUEST_CODE_LOGIN:

                if (resultCode == RESULT_OK) {

                    Bundle bundle = data.getExtras();

                    if (bundle.containsKey(InstagramKitConstants.kSessionKey)) {

                        final IGSession session = (IGSession) bundle.getSerializable(InstagramKitConstants.kSessionKey);

                        assert session != null;
                        mPreferencesManager.saveAuthToken(session);


                        Toast.makeText(InstaActivity.this, "Logged" + mPreferencesManager.getAuthToken(),
                                Toast.LENGTH_LONG).show();

                        mDataManager.userInfo(mPreferencesManager.getAuthToken()).enqueue(new Callback<UserInfoRes>() {
                            @Override
                            public void onResponse(Call<UserInfoRes> call, Response<UserInfoRes> response) {
                                if (response.isSuccessful()) {
                                    loginSuccess(response.body());

                                    mFollowedByView.setText(String.valueOf(response.body().getData().getCounts().getFollowedBy()));
                                    mFollowed.setText(String.valueOf(response.body().getData().getCounts().getFollows()));
                                    mFullName.setText(response.body().getData().getFullName());
                                    mUserName.setText(response.body().getData().getUsername());
                                    if (mUserBio != null)
                                        mUserBio.setText(getString(R.string.about_me) + response.body().getData().getBio());
                                    if (mUserWebsite != null)
                                        mUserWebsite.setText(getString(R.string.website) + response.body().getData().getWebsite());
                                    insertDrawerAvatar(Uri.parse(response.body().getData().getProfilePicture()));
                                    mPreferencesManager.saveUserId(response.body().getData().getId());

                                    mMapButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(InstaActivity.this, MapsActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                                    //TEST
                                    String lat = "";
                                    String log = "";
                                    for (int i = 0; i < mPreferencesManager.getLatitude().size();i++){
                                        lat+=String.valueOf(mPreferencesManager.getLatitude().get(i))+"\n";
                                        log+=String.valueOf(mPreferencesManager.getLongitude().get(i))+"\n";
                                    }
                                    Toast.makeText(InstaActivity.this, lat,Toast.LENGTH_LONG).show();
                                    Toast.makeText(InstaActivity.this, log,Toast.LENGTH_LONG).show();



                                }
                            }

                            @Override
                            public void onFailure(Call<UserInfoRes> call, Throwable t) {

                            }
                        });

                        mDataManager.userMediaInfo(mPreferencesManager.getUserId(), mPreferencesManager.getAuthToken(), 50, 0, 5).enqueue(new Callback<UserMediaRes>() {
                            @Override
                            public void onResponse(Call<UserMediaRes> call, Response<UserMediaRes> response) {
                                if (response.isSuccessful()) {
                                    List<Double> photoLatitude = new ArrayList<>();
                                    List<Double> photoLongitude = new ArrayList<>();
                                    for (DataItem dataItem : response.body().getData()) {
                                        photoLatitude.add(dataItem.getLocation().getLatitude());
                                        photoLongitude.add(dataItem.getLocation().getLongitude());
                                    }
                                    mPreferencesManager.saveLatitude(photoLatitude);
                                    mPreferencesManager.saveLongitude(photoLongitude);


                                    String tags = getString(R.string.tags_and_likes);
                                    for (DataItem dataItem : response.body().getData()) {
                                        for (String tag : dataItem.getTags()) {
                                            tags += "\n" + "#" + tag + " ";
                                        }
                                        tags += String.valueOf(dataItem.getLikes().getCount()) + " " + dataItem.getFilter() + "\n";
                                    }
                                    mTags.setText(tags);
                                }
                            }

                            @Override
                            public void onFailure(Call<UserMediaRes> call, Throwable t) {

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

    public void genericClickListener(View v) {
        switch (v.getId()) {
            case R.id.logout:
                InstagramEngine.getInstance(InstaActivity.this).logout(InstaActivity.this, InstagramEngine.REQUEST_CODE_LOGOUT);
        }
    }

    private void loginSuccess(UserInfoRes userInfoRes) {
        mPreferencesManager.saveUserPhoto(Uri.parse(userInfoRes.getData().getProfilePicture()));
        mPreferencesManager.saveUserId(userInfoRes.getData().getId());
        saveUserData(userInfoRes);
    }

    private void saveUserData(UserInfoRes userInfoRes) {
        List<String> userData = new ArrayList<>();
        userData.add(String.valueOf(userInfoRes.getData().getCounts().getFollowedBy()));
        userData.add(String.valueOf(userInfoRes.getData().getCounts().getFollows()));
        userData.add(userInfoRes.getData().getFullName());
        userData.add(userInfoRes.getData().getUsername());
        userData.add(userInfoRes.getData().getBio());
        userData.add(userInfoRes.getData().getWebsite());
        userData.add(String.valueOf(userInfoRes.getData().getProfilePicture()));

        mPreferencesManager.saveUserProfileData(userData);
    }
}
