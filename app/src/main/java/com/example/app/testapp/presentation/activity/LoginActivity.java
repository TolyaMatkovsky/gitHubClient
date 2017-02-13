package com.example.app.testapp.presentation.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.app.testapp.R;
import com.example.app.testapp.data.manager.SettingsManager;
import com.example.app.testapp.data.service.AccessToken;
import com.example.app.testapp.data.service.LoginService;
import com.example.app.testapp.data.service.ServiceGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.app.testapp.data.service.OAuth.*;


/**
 * Created by Tolik on 09.02.2017.
 */

public class LoginActivity extends AppCompatActivity {
    private static int SPLASH_TIME = 1500;

    @BindView(R.id.webviewRelativeLayout)
    RelativeLayout webviewRelativeLayout;
    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.blind_view)
    View blindView;
    @BindView(R.id.progressbar_black)
    ProgressBar progressBarBlack;
    @BindView(R.id.blind_webview)
    RelativeLayout blindWebView;

    private Unbinder unbinder;
    private SettingsManager settingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unbinder = ButterKnife.bind(this);
        settingsManager = SettingsManager.getInstance(getApplicationContext());

        if (settingsManager.isUserLogout()) {
            clearCookie();
        }

        initializeWebView();

        webView.loadUrl(AUTHORIZE + "?scope=" + SCOPES + "&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI);
        if (settingsManager.isFirstTime() || settingsManager.isUserLogout()) {
            settingsManager.setFirstTime(false);
            settingsManager.saveFirstTime();
        } else {
            blindWebView.setVisibility(View.VISIBLE);
        }
    }

    private void getTokenByCode(String code) {
        if (code != null) {

            showLoading(true);

            LoginService loginService =
                    ServiceGenerator.createService(LoginService.class);

            Call<String> call = loginService.getAccessToken(CLIENT_ID, CLIENT_SECRET, code, REDIRECT_URI);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.body() != null) {
                        String responseString = response.body();

                        String[] items = responseString.split("&");
                        String accessTokenValue = items[0].split("=")[1];
                        String scopeValue = items[1].split("=")[1];
                        String tokenTypeValue = items[2].split("=")[1];

                        AccessToken accessToken = new AccessToken(accessTokenValue, scopeValue, tokenTypeValue);
                        Log.e("RESP", accessToken.toString());

                        settingsManager.setAccessToken(accessToken);
                        settingsManager.save();

                        showLoading(false);
                        moveToUserResults();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    showLoading(false);

                    Log.e("RESPONSE", "_FAILURE_");
                    t.printStackTrace();
                }
            });
        }
    }

    private void initializeWebView() {

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                if (url.startsWith(REDIRECT_URI)) {

                    destroyWebView(webView);

                    String codeValue = url.split("=")[1];
                    getTokenByCode(codeValue);

                } else {
                    webView.loadUrl(url);
                }
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBarBlack.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBarBlack.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }

    private void destroyWebView(WebView webView) {
        webviewRelativeLayout.removeView(webView);
        webView.setFocusable(true);
        webView.removeAllViews();
        webView.clearHistory();
        webView.clearFormData();
        webView.clearCache(true);
        webView.destroy();
    }

    private void clearCookie() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance(this);
            cookieSyncManager.startSync();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncManager.stopSync();
            cookieSyncManager.sync();
        }
    }

    private void moveToUserResults() {
        startActivity(new Intent(this, MainActivity.class));
//        overridePendingTransition(R.anim.zoom_enter_anim, R.anim.zoom_exit_anim);
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void showLoading(boolean enabled) {
        if (enabled) {
            blindView.setVisibility(View.VISIBLE);
        } else {
            blindView.setVisibility(View.GONE);
            progressBarBlack.setVisibility(View.GONE);
        }
    }
}
