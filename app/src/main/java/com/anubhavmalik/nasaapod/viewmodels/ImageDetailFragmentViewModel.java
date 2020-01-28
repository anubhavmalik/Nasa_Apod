package com.anubhavmalik.nasaapod.viewmodels;

import com.anubhavmalik.nasaapod.models.ImageModel;
import com.anubhavmalik.nasaapod.repositories.ImageDataRepository;

import androidx.lifecycle.ViewModel;

/**
 * Created by Anubhav Malik on Wed 29 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class ImageDetailFragmentViewModel extends ViewModel {
    public ImageModel imageModel;

    public ImageDetailFragmentViewModel() {
    }

    public void initializeImageModelFromPosition(int position){
        imageModel = ImageDataRepository.getInstance().getImageModelAtPosition(position);
    }
}
