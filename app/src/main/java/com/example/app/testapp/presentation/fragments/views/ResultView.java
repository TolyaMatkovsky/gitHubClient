package com.example.app.testapp.presentation.fragments.views;

import com.example.app.testapp.data.entity.User;

/**
 * Created by Tolik on 10.02.2017.
 */

public interface ResultView extends DataView {
    void renderUser(User user);
}
