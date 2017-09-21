package com.project.darkhorsestd.instagramloger.data.network.interceptors;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.project.darkhorsestd.instagramloger.data.managers.DataManager;
import com.project.darkhorsestd.instagramloger.data.managers.PreferencesManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lenovo on 21.09.2017.
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException{

        PreferencesManager pm = DataManager.getInstance().getPreferencesManager();
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("X-Access-Token", pm.getAuthToken())
                .header("User-Agent", "InstaLoger");
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
