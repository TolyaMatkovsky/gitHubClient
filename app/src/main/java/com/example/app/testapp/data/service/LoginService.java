package com.example.app.testapp.data.service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Tolik on 09.02.2017.
 */

public interface LoginService {

    @FormUrlEncoded
    @POST("https://github.com/login/oauth/access_token")
    Call<String> getAccessToken(
            @Field("client_id") String clientID,
            @Field("client_secret") String clientSecret,
            @Field("code") String code,
            @Field("redirect_uri") String redirectURI);
}
