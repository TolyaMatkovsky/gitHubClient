// Generated code from Butter Knife. Do not modify!
package com.example.app.testapp.presentation.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.app.testapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReposAdapter$ReposViewHolder_ViewBinding<T extends ReposAdapter.ReposViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ReposAdapter$ReposViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.language = Utils.findRequiredViewAsType(source, R.id.language, "field 'language'", TextView.class);
    target.reposTitle = Utils.findRequiredViewAsType(source, R.id.repos_title, "field 'reposTitle'", TextView.class);
    target.forceCount = Utils.findRequiredViewAsType(source, R.id.force_count, "field 'forceCount'", TextView.class);
    target.starCount = Utils.findRequiredViewAsType(source, R.id.star_count, "field 'starCount'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.language = null;
    target.reposTitle = null;
    target.forceCount = null;
    target.starCount = null;

    this.target = null;
  }
}
