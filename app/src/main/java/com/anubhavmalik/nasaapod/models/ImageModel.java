package com.anubhavmalik.nasaapod.models;

import com.anubhavmalik.nasaapod.adapters.clicklisteners.GridClickListener;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class ImageModel {

    public ImageModel() {
    }

    @SerializedName("copyright")
    private String copyRight;

    @SerializedName("date")
    private String date;

    @SerializedName("explanation")
    private String explanation;

    @SerializedName("hdurl")
    private String highDefURL;

    @SerializedName("media_type")
    private String mediaType;

    @SerializedName("service_version")
    private String serviceVersion;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String lowDefURL;

    private GridClickListener gridClickListener;

    public GridClickListener getGridClickListener() {
        return gridClickListener;
    }

    public void setGridClickListener(GridClickListener gridClickListener) {
        this.gridClickListener = gridClickListener;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHighDefURL() {
        return highDefURL;
    }

    public void setHighDefURL(String highDefURL) {
        this.highDefURL = highDefURL;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLowDefURL() {
        return lowDefURL;
    }

    public void setLowDefURL(String lowDefURL) {
        this.lowDefURL = lowDefURL;
    }

    public void onItemClicked(){
        if(gridClickListener!=null){
            gridClickListener.onItemClicked(this, -1);
        }
    }
}
