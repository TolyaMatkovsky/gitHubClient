// Generated code from Butter Knife. Do not modify!
package com.example.app.testapp.presentation.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.app.testapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchFragment_ViewBinding<T extends SearchFragment> implements Unbinder {
  protected T target;

  private View view2131558553;

  @UiThread
  public SearchFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.githubLogin = Utils.findRequiredViewAsType(source, R.id.github_login, "field 'githubLogin'", AppCompatEditText.class);
    view = Utils.findRequiredView(source, R.id.home_look_up, "method 'lookUpUserInNet'");
    view2131558553 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.lookUpUserInNet();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.githubLogin = null;

    view2131558553.setOnClickListener(null);
    view2131558553 = null;

    this.target = null;
  }
}
