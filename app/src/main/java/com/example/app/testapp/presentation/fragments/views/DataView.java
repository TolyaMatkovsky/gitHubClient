package com.example.app.testapp.presentation.fragments.views;

/**
 * Created by Tolik on 10.02.2017.
 */

public interface DataView {
    void showError(String message);
    void showLoading(String message);
    void hideLoading();
    void showInternetDisconnectMessage();
}
