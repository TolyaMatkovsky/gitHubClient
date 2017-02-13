package com.example.app.testapp.data.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.app.testapp.data.service.AccessToken;

/**
 * Created by Tolik on 10.02.2017.
 */

public class SettingsManager {
    private static final String PREF_FILE_NAME = "com.example.app.testapp.SHARED_PREFERENCES";

    private static final String KEY_TOKEN = "token";
    private static final String KEY_SCOPE = "scope";
    private static final String KEY_TOKEN_TYPE = "token_type";
    private static final String KEY_IS_USER_LOGOUT = "is_user_logout";
    private static final String KEY_IS_FIRST_TIME = "is_first_time";

    private AccessToken accessToken;
    private boolean isUserLogout;
    private boolean isFirstTime;

    private static SettingsManager instance;
    private Context context;

    public static SettingsManager getInstance(Context context) {
        if (instance == null) {
            instance = new SettingsManager(context);
        }
        return instance;
    }

    private SettingsManager(Context context) {
        this.context = context.getApplicationContext();
        initialize();
    }

    public void saveFirstTime(){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(KEY_IS_FIRST_TIME, isFirstTime);
        editor.apply();
    }

    public void save() {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(KEY_TOKEN, accessToken.getAccessToken());
        editor.putString(KEY_SCOPE, accessToken.getScope());
        editor.putString(KEY_TOKEN_TYPE, accessToken.getTokenType());
        editor.putBoolean(KEY_IS_USER_LOGOUT, isUserLogout);

        editor.apply();
    }

    public void initialize() {
        load();
    }

    private void load() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(KEY_TOKEN, "");
        String scope = sharedPreferences.getString(KEY_SCOPE, "");
        String tokenType = sharedPreferences.getString(KEY_TOKEN_TYPE, "");

        accessToken = new AccessToken(token, scope, tokenType);

        isUserLogout = sharedPreferences.getBoolean(KEY_IS_USER_LOGOUT, false);
        isFirstTime = sharedPreferences.getBoolean(KEY_IS_FIRST_TIME, true);
    }

    public void clear() {
        context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).edit().clear().apply();
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isUserLogout() {
        return isUserLogout;
    }

    public void setUserLogout(boolean userLogout) {
        isUserLogout = userLogout;
    }

    public boolean isEmptyAccessToken() {
        return accessToken.getAccessToken().isEmpty();
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }
}
