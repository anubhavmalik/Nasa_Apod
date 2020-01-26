package com.anubhavmalik.nasaapod.viewmodels;

import com.anubhavmalik.nasaapod.models.ImageModel;
import com.anubhavmalik.nasaapod.repositories.ImageDataRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class GridActivityViewModel extends ViewModel {
    private ImageDataRepository imageDataRepository;

    public GridActivityViewModel() {
        imageDataRepository = ImageDataRepository.getInstance();
    }

    public MutableLiveData<List<ImageModel>> getMutableLiveData() {
        return imageDataRepository.getImageModelMutableLiveData();
    }
}
