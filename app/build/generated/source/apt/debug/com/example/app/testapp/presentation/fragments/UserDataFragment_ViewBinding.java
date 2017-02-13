// Generated code from Butter Knife. Do not modify!
package com.example.app.testapp.presentation.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.app.testapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserDataFragment_ViewBinding<T extends UserDataFragment> implements Unbinder {
  protected T target;

  @UiThread
  public UserDataFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.userPhoto = Utils.findRequiredViewAsType(source, R.id.user_photo, "field 'userPhoto'", ImageView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.results_recycle_view, "field 'recyclerView'", RecyclerView.class);
    target.followers = Utils.findRequiredViewAsType(source, R.id.results_followers_count, "field 'followers'", TextView.class);
    target.following = Utils.findRequiredViewAsType(source, R.id.results_following_count, "field 'following'", TextView.class);
    target.gists = Utils.findRequiredViewAsType(source, R.id.results_gists, "field 'gists'", TextView.class);
    target.repos = Utils.findRequiredViewAsType(source, R.id.results_repos, "field 'repos'", TextView.class);
    target.reposName = Utils.findRequiredViewAsType(source, R.id.name, "field 'reposName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.userPhoto = null;
    target.recyclerView = null;
    target.followers = null;
    target.following = null;
    target.gists = null;
    target.repos = null;
    target.reposName = null;

    this.target = null;
  }
}
