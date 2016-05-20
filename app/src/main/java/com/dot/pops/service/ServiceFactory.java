package com.dot.Pops.service;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Win7 on 03/05/2016.
 */
public class ServiceFactory {


    public static <T> T createRetrofitService(Context context, final Class<T> clazz, final String endPoint) {
        long TIME_OUT   = 1 * 1000;

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(TIME_OUT, TimeUnit.MINUTES)
                    .readTimeout(TIME_OUT, TimeUnit.MINUTES)
                    .build();
        OkHttpClient client = clientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        T service = retrofit.create(clazz);

        return service;
    }
}
