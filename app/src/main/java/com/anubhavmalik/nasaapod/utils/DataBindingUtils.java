package com.anubhavmalik.nasaapod.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;

import androidx.databinding.BindingAdapter;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class DataBindingUtils {
    @BindingAdapter({"setImageURL"})
    public static void setImageURL(ImageView imageView, String imageURL){
        if(imageURL!=null && imageView!=null){
            Glide.with(imageView.getContext())
                    .asBitmap()
                    .load(imageURL)
                    .format(DecodeFormat.PREFER_RGB_565)
                    .into(imageView);
        }
    }
}
