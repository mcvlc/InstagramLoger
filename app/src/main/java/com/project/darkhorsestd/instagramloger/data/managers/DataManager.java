package com.project.darkhorsestd.instagramloger.data.managers;


import android.content.Context;

import com.project.darkhorsestd.instagramloger.InstaLogerApplication;
import com.project.darkhorsestd.instagramloger.data.network.RestService;
import com.project.darkhorsestd.instagramloger.data.network.ServiceGenerator;
import com.project.darkhorsestd.instagramloger.data.network.res.UserFollowersRes;
import com.project.darkhorsestd.instagramloger.data.network.res.UserInfoRes;
import com.project.darkhorsestd.instagramloger.data.network.res.UserMediaRes;

import retrofit2.Call;


public class DataManager {
    private static DataManager INSTANCE = null;

    private Context mContext;
    private PreferencesManager mPreferencesManager;
    private RestService mRestService;

    public DataManager(){
        this.mPreferencesManager = new PreferencesManager();
        this.mContext = InstaLogerApplication.getContext();
        this.mRestService = ServiceGenerator.createService(RestService.class);
    }

    public static DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }

        return INSTANCE;
    }

    public PreferencesManager getPreferencesManager(){
        return mPreferencesManager;
    }

    public Context getContext(){
        return mContext;
    }

    //region ====== NetWork ======
    public Call<UserInfoRes> userInfo(String accessToken){
       return mRestService.getUserInfo(accessToken);
    }

    public Call<UserMediaRes> userMediaInfo(String userId, String accessToken, int maxId, int minId, int count){
        return mRestService.getMediaInfo(userId,accessToken,maxId,minId,count);
    }

    public Call<UserFollowersRes> userFollowersList(String accessToken){
        return mRestService.getFollowersList(accessToken);
    }
    //endregion
}
