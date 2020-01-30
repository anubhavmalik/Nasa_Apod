package com.anubhavmalik.nasaapod.repositories;

import com.anubhavmalik.nasaapod.models.ImageModel;
import com.anubhavmalik.nasaapod.utils.JSONUtils;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class ImageDataRepository {
    private static ImageDataRepository imageDataRepository;
    private MutableLiveData<List<ImageModel>> imageModelMutableLiveData = new MutableLiveData<>();
    private List<ImageModel> imageModelList = JSONUtils.getInstance().getImageModelsFromJSONFile();

    public static ImageDataRepository getInstance() {
        if (imageDataRepository == null) {
            imageDataRepository = new ImageDataRepository();
        }
        return imageDataRepository;
    }

    public List<ImageModel> getImageModelList() {
        return imageModelList;
    }

    public MutableLiveData<List<ImageModel>> getImageModelMutableLiveData() {
        if (imageModelMutableLiveData != null && imageModelMutableLiveData.getValue() == null) {
            if (imageModelList != null) {
                imageModelMutableLiveData.postValue(imageModelList);
            }
        }
        return imageModelMutableLiveData;
    }

    public ImageModel getImageModelAtPosition(int position) {
        if (imageModelList != null && imageModelList.size() > position) {
            return imageModelList.get(position);
        }
        return null;
    }
}
