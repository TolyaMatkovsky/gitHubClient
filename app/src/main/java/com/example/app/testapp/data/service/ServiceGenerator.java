package com.example.app.testapp.data.service;

import android.text.TextUtils;

import com.example.app.testapp.data.service.converter.BitmapConverterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Tolik on 09.02.2017.
 */

public class ServiceGenerator {

    public static final String API_BASE_URL = "https://api.github.com/";

    private static Retrofit retrofit;

    private static Gson gson =
            new GsonBuilder()
                .setLenient()
                .create();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(BitmapConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public static <S> S createService(
            Class<S> serviceClass, AccessToken accessToken) {
        if (accessToken != null
                &&!TextUtils.isEmpty(accessToken.getAccessToken())
                && !TextUtils.isEmpty(accessToken.getTokenType())) {
            return createService(serviceClass, accessToken, true);
        }

        return createService(serviceClass, null, false);
    }

    private static <S> S createService(
            Class<S> serviceClass, final AccessToken accessToken, boolean withToken) {
        if (withToken) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor(accessToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(logging);
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }else {
            if (!httpClient.interceptors().contains(logging)) {
                httpClient.addInterceptor(logging);
                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
        return retrofit.create(serviceClass);
    }
}
