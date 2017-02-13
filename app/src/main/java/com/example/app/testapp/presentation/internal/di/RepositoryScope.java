package com.example.app.testapp.presentation.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Tolik on 13.02.2017.
 */

@Scope
@Retention(RUNTIME)
public @interface RepositoryScope {}
