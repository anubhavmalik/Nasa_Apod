package com.anubhavmalik.nasaapod.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.anubhavmalik.nasaapod.activities.ImageDetailActivity;
import com.anubhavmalik.nasaapod.constants.AppConstants;

/**
 * Created by Anubhav Malik on Wed 29 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class IntentUtils {
    private static IntentUtils intentUtils;

    public static IntentUtils getInstance(){
        if(intentUtils==null){
            intentUtils = new IntentUtils();
        }
        return intentUtils;
    }

    public void openImageDetailActivity(Context context, int position){
        if(context!=null){
            Bundle bundle = new Bundle();
            bundle.putInt(AppConstants.ADAPTER_POSITION, position);

            Intent intent = new Intent(context, ImageDetailActivity.class);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }
}
