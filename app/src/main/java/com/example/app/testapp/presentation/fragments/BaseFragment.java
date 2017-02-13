package com.example.app.testapp.presentation.fragments;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;


import com.example.app.testapp.R;
import com.example.app.testapp.data.manager.AlertManager;
import com.example.app.testapp.presentation.fragments.views.DataView;
import com.example.app.testapp.presentation.internal.di.HasComponent;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Tolik on 11.02.2017.
 */

public class BaseFragment extends Fragment implements DataView {
    private SweetAlertDialog progressBar;

    protected String getResString(int strRes) {
        return getContext().getResources().getString(strRes);
    }

    public void showError(String message) {
        AlertManager.showToast(getContext(), message);
    }

    @Override
    public void showLoading(String message) {
        progressBar = AlertManager.showSweetProgressBar(getContext(), message);
        progressBar.show();
    }

    @Override
    public void hideLoading() {
        if (progressBar.isShowing()) {
            progressBar.dismiss();
        }
    }

    @Override
    public void showInternetDisconnectMessage() {
        AlertManager.showSweetWarning(getContext(), getResString(R.string.internet_problem), getResString(R.string.please_connect));
    }

    protected void showError() {
        progressBar.dismiss();
        AlertManager.showToast(getContext(), getResString(R.string.something_wrong));
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) this).getComponent());
    }
}
