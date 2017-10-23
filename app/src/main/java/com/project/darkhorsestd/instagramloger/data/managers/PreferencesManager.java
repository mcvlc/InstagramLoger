package com.project.darkhorsestd.instagramloger.data.managers;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;

import com.instagram.instagramapi.objects.IGLocation;
import com.instagram.instagramapi.objects.IGSession;
import com.project.darkhorsestd.instagramloger.InstaLogerApplication;
import com.project.darkhorsestd.instagramloger.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;


public class PreferencesManager {
    private static SharedPreferences mSharedPreferences;
    private int latitudeCounter = 0;
    private int longitudeCounter = 0;
    private int followersCounter = 0;

    public PreferencesManager() {
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


    public void saveUserProfileData(List<String> userFields) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for (int i = 0; i < USER_FIELDS.length; i++) {
            editor.putString(USER_FIELDS[i], userFields.get(i));
        }

        editor.apply();
    }

    public List<String> loadUserProfileData() {
        List<String> userFields = new ArrayList<>();
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_FOLLOWERS_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_USERNAME_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_FULLNAME_KEY, "null"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_PROFILE_PICTURE_KEY, "null"));

        return userFields;
    }


    public void saveUserPhoto(Uri uri) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_PROFILE_PICTURE_KEY, uri.toString());
        editor.apply();
    }

    public void saveAuthToken(IGSession session) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.AUTH_TOKEN, session.getAccessToken());
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

    //
    public void saveLatitude(List<Double> photoLatitude) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for (int i = 0; i < photoLatitude.size(); i++) {
            editor.putString(ConstantManager.USER_LATITUDE_VALUE + i, String.valueOf(photoLatitude.get(i)));
            latitudeCounter++;
        }
        editor.apply();
    }

    public void saveLongitude(List<Double> photoLongitude) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for (int i = 0; i < photoLongitude.size(); i++) {
            editor.putString(ConstantManager.USER_LONGITUDE_VALUE + i, String.valueOf(photoLongitude.get(i)));
            longitudeCounter++;
        }
        editor.apply();
    }

    public List<Float> getLatitude() {
        List<Float> latitudeValues = new ArrayList<>();
        for (int i = 0; i < latitudeCounter; i++) {
            latitudeValues.add(Float.parseFloat(mSharedPreferences
                    .getString(ConstantManager.USER_LATITUDE_VALUE + i, String.valueOf(0.0f))));
        }
        return latitudeValues;
    }

    public List<Float> getLongitude() {
        List<Float> longitudeValues = new ArrayList<>();

        for (int i = 0; i < longitudeCounter; i++) {
            longitudeValues.add(
                    Float.parseFloat(mSharedPreferences
                            .getString(ConstantManager.USER_LONGITUDE_VALUE + i,String.valueOf(0.0f))));
        }

        return longitudeValues;
    }

    public void saveFollowersList(List<String> followersList){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for(int i = 0; i < followersList.size();i++){
            editor.putString(ConstantManager.USER_FOLLOWERS_LIST_VALUE+i, followersList.get(i));
            followersCounter++;
        }
        editor.apply();
    }

    public  List<String> getFollowersList(){
        List<String> followersList = new ArrayList<>();

        for(int i = 0; i <followersCounter;i++){
            followersList.add(mSharedPreferences.getString(ConstantManager.USER_FOLLOWERS_LIST_VALUE+i, "null"));
        }

        return followersList;
    }
}
