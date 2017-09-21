package com.project.darkhorsestd.instagramloger.data.managers;

import android.content.SharedPreferences;
import android.net.Uri;

import com.instagram.instagramapi.objects.IGSession;
import com.project.darkhorsestd.instagramloger.InstaLogerApplication;

import java.util.ArrayList;
import java.util.List;



public class PreferencesManager {
    private static SharedPreferences mSharedPreferences;
    private static final String AUTH_TOKEN = "AUTH_TOKEN";
    private static final String USER_ID = "USER_ID";

    private static final String USER_FOLLOWERS_KEY = "USER_FOLLOWERS_KEY";

    private static final String USER_USERNAME_KEY = "USER_USERNAME_KEY";
    private static final String USER_FULLNAME_KEY = "USER_FULLNAME_KEY";
    private static final String USER_PROFILE_PICTURE_KEY = "USER_PROFILE_PICTURE_KEY";


    public PreferencesManager(){
        mSharedPreferences = InstaLogerApplication.getsSharedPreferences();
    }

    private static final String[] USER_FIELDS = {
            USER_FOLLOWERS_KEY,
            USER_USERNAME_KEY,
            USER_FULLNAME_KEY,

    };

    private static final String USER_FOLLOWERS_VALUE = "USER_FOLLOWERS_VALUE";
    private static final String USER_USERNAME_VALUE = "USER_USERNAME_VALUE";
    private static final String USER_FULLNAME_VALUE = "USER_FULLNAME_VALUE";
    private static final String USER_PROFILE_PICTURE_VALUE = "USER_PROFILE_PICTURE_VALUE";
    private static final String[] USER_VALUES = {
            USER_FOLLOWERS_VALUE,
            USER_USERNAME_VALUE,
            USER_FULLNAME_VALUE,
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
        userFields.add(mSharedPreferences.getString(USER_FOLLOWERS_KEY,"null"));
        userFields.add(mSharedPreferences.getString(USER_USERNAME_KEY,"null"));
        userFields.add(mSharedPreferences.getString(USER_FULLNAME_KEY,"null"));
        userFields.add(mSharedPreferences.getString(USER_PROFILE_PICTURE_KEY,"null"));

        return userFields;
    }



   /* public void saveUserPhoto(Uri uri){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USER_PROFILE_PICTURE_KEY, uri.toString());
        editor.apply();
    }

    private Uri loadUserPhoto(){
        return Uri.parse(mSharedPreferences.getString(USER_PROFILE_PICTURE_KEY, "android.resource://"))
    }*/

    public void saveAuthToken(IGSession session) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
       // editor.putString(AUTH_TOKEN, authToken);
        editor.putString(AUTH_TOKEN,session.getAccessToken() );
        editor.apply();
    }

    public String getAuthToken() {
        return mSharedPreferences.getString(AUTH_TOKEN, "null");
    }

    public void saveUserId(String userId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USER_ID, userId);
        editor.apply();
    }

    public String getUserId() {
        return mSharedPreferences.getString(USER_ID, "null");
    }


}
