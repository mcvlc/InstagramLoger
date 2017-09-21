package com.project.darkhorsestd.instagramloger.data.network;

import com.project.darkhorsestd.instagramloger.data.network.res.UserInfoRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface RestService {
    @GET("users/self")
    Call<UserInfoRes> getUserInfo(@Query("access_token")String accessToken);
}
