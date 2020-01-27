package com.anubhavmalik.nasaapod.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class NasaApp extends Application {
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        initVariables();
    }

    private void initVariables() {
        applicationContext = this;
    }

    public static Context getNonUIContext(){
        return applicationContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

}
