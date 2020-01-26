package com.anubhavmalik.nasaapod.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class ImageModel {

    public ImageModel() {
    }

    @SerializedName("copyRight")
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


    //"copyright": "ESA/HubbleNASA",
//        "date": "2019-12-01",
//        "explanation": "Why does this galaxy have a ring of bright blue stars?  Beautiful island universe Messier 94 lies a mere 15 million light-years distant in the northern constellation of the Hunting Dogs (Canes Venatici). A popular target for Earth-based astronomers, the face-on spiral galaxy is about 30,000 light-years across, with spiral arms sweeping through the outskirts of its broad disk. But this Hubble Space Telescope field of view spans about 7,000 light-years across M94's central region. The featured close-up highlights the galaxy's compact, bright nucleus, prominent inner dust lanes, and the remarkable bluish ring of young massive stars. The ring stars are all likely less than 10 million years old, indicating that M94 is a starburst galaxy that is experiencing an epoch of rapid star formation from inspiraling gas. The circular ripple of blue stars is likely a wave propagating outward, having been triggered by the gravity and rotation of a oval matter distributions. Because M94 is relatively nearby, astronomers can better explore details of its starburst ring.    Astrophysicists: Browse 2,000+ codes in the Astrophysics Source Code Library",
//        "hdurl": "https://apod.nasa.gov/apod/image/1912/M94_Hubble_1002.jpg",
//        "media_type": "image",
//        "service_version": "v1",
//        "title": "Starburst Galaxy M94 from Hubble",
//        "url": "https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg"
}
