package com.example.app.testapp.data.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tolik on 09.02.2017.
 */
public class AuthenticationInterceptor implements Interceptor {

    private AccessToken accessToken;

    public AuthenticationInterceptor(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken());

        Request request = builder.build();
        return chain.proceed(request);
    }
}
