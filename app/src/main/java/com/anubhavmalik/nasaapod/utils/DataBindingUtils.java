package com.anubhavmalik.nasaapod.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.anubhavmalik.nasaapod.models.ImageModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jsibbold.zoomage.ZoomageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class DataBindingUtils {
    @BindingAdapter(value = {"setImageURL", "setProgressBar"}, requireAll = true)
    public static void setImageURL(ZoomageView imageView, String imageURL, final ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        if (imageURL != null && imageView != null) {
            Glide.with(imageView.getContext())
                    .load(imageURL)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .format(DecodeFormat.PREFER_RGB_565)
                    .override(ScreenUtils.getScreenWidth()/2, ScreenUtils.getScreenWidth() / 3)
                    .into(imageView);
        }
    }

    @BindingAdapter(value = {"setImageURL", "setProgressBar"}, requireAll = true)
    public static void setImageURL(ImageView imageView, String imageURL, final ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        if (imageURL != null && imageView != null) {
            Glide.with(imageView.getContext())
                    .load(imageURL)
                    .thumbnail(0.2f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .format(DecodeFormat.PREFER_RGB_565)
                    .into(imageView);
        }
    }

    @BindingAdapter(value = {"setShouldShow"})
    public static void setShouldShow(View view, ObservableBoolean shouldShow){
        if(view!=null && shouldShow!=null){
            if(shouldShow.get()){
                view.setAlpha(1f);
            }else {
                view.setAlpha(0);
            }
        }
    }
}
