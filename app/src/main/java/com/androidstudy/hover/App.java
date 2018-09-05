package com.androidstudy.hover;

import android.app.Application;

import com.hover.sdk.api.Hover;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Hover.initialize(this);
    }
}
