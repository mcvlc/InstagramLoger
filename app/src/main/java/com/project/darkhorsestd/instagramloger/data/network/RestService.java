package com.project.darkhorsestd.instagramloger.data.network;
import com.project.darkhorsestd.instagramloger.data.network.res.UserInfoRes;
import com.project.darkhorsestd.instagramloger.data.network.res.UserMediaRes;
import com.project.darkhorsestd.instagramloger.data.network.res.followers.UserFollowersRes;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RestService {
    @GET("users/self")
    Call<UserInfoRes> getUserInfo(@Query("access_token")String accessToken);

    @GET("users/{user-id}/media/recent/")
    Call<UserMediaRes> getMediaInfo(@Path("user-id") String userId, @Query("access_token")String accessToken, @Query("MAX_ID") int max_id, @Query("MIN_ID") int min_id, @Query("COUNT") int count);

    @GET("users/self/followed-by")
    Call<UserFollowersRes> getFollowersList(@Query("access_token")String accessToken);
}
