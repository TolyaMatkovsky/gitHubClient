// Generated code from Butter Knife. Do not modify!
package com.example.app.testapp.presentation.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.app.testapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding<T extends LoginActivity> implements Unbinder {
  protected T target;

  @UiThread
  public LoginActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.webviewRelativeLayout = Utils.findRequiredViewAsType(source, R.id.webviewRelativeLayout, "field 'webviewRelativeLayout'", RelativeLayout.class);
    target.webView = Utils.findRequiredViewAsType(source, R.id.webview, "field 'webView'", WebView.class);
    target.blindView = Utils.findRequiredView(source, R.id.blind_view, "field 'blindView'");
    target.progressBarBlack = Utils.findRequiredViewAsType(source, R.id.progressbar_black, "field 'progressBarBlack'", ProgressBar.class);
    target.blindWebView = Utils.findRequiredViewAsType(source, R.id.blind_webview, "field 'blindWebView'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.webviewRelativeLayout = null;
    target.webView = null;
    target.blindView = null;
    target.progressBarBlack = null;
    target.blindWebView = null;

    this.target = null;
  }
}
