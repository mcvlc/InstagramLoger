package com.project.darkhorsestd.instagramloger.data.managers;

import android.content.SharedPreferences;
import android.net.Uri;

import com.instagram.instagramapi.objects.IGSession;
import com.project.darkhorsestd.instagramloger.InstaLogerApplication;
import com.project.darkhorsestd.instagramloger.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;



public class PreferencesManager {
    private static SharedPreferences mSharedPreferences;


    public PreferencesManager(){
        mSharedPreferences = InstaLogerApplication.getsSharedPreferences();
    }

    private static final String[] USER_FIELDS = {
            ConstantManager.USER_FOLLOWERS_KEY,
            ConstantManager.USER_USERNAME_KEY,
            ConstantManager.USER_FULLNAME_KEY,

    };


    private static final String[] USER_VALUES = {
            ConstantManager.USER_FOLLOWERS_VALUE,
            ConstantManager.USER_USERNAME_VALUE,
            ConstantManager.USER_FULLNAME_VALUE,
    };


    public void saveUserProfileData(List<String> userFields){
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for(int i = 0; i < USER_FIELDS.length;i++){
            editor.putString(USER_FIELDS[i], userFields.get(i));
        }

        editor.apply();
    }

    public List<String> loadUserProfileData(){
        List<String> userFields = new ArrayList<>();
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_FOLLOWERS_KEY,"null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_USERNAME_KEY,"null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_FULLNAME_KEY,"null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_PROFILE_PICTURE_KEY,"null"));

        return userFields;
    }


    public void saveUserPhoto(Uri uri){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_PROFILE_PICTURE_KEY,uri.toString());
        editor.apply();
    }

    public void saveAuthToken(IGSession session) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.AUTH_TOKEN,session.getAccessToken() );
        editor.apply();
    }

    public String getAuthToken() {
        return mSharedPreferences.getString(ConstantManager.AUTH_TOKEN, "null");
    }

    public void saveUserId(String userId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_ID, userId);
        editor.apply();
    }

    public String getUserId() {
        return mSharedPreferences.getString(ConstantManager.USER_ID, "null");
    }


}
