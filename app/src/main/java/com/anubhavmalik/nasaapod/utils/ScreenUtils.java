package com.anubhavmalik.nasaapod.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.anubhavmalik.nasaapod.app.NasaApp;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class ScreenUtils {
    private static ScreenUtils commonScreenUtils;

    private ScreenUtils() {
        // This utility class is not publicly instantiable
    }

    public static ScreenUtils getInstance() {
        if (commonScreenUtils == null) {
            commonScreenUtils = new ScreenUtils();
        }
        return commonScreenUtils;
    }

    public static int getScreenWidth() {
        WindowManager windowManager = (WindowManager) NasaApp.getNonUIContext()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
