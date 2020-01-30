package com.anubhavmalik.nasaapod.utils;

import com.anubhavmalik.nasaapod.app.NasaApp;
import com.anubhavmalik.nasaapod.models.ImageModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class JSONUtils {
    private static JSONUtils jsonUtils;
    private static Gson gson;
    private static String json = "";

    public static JSONUtils getInstance() {
        if (jsonUtils == null) {
            jsonUtils = new JSONUtils();
            gson = new Gson();
        }
        return jsonUtils;
    }

    public List<ImageModel> getImageModelsFromJSONFile() {
        if (json.isEmpty()) {
            json = loadJSONFromAsset();
        }
        if (json != null) {
            if (!json.isEmpty()) {
                try {
                    List<ImageModel> list = gson.fromJson(json, new TypeToken<List<ImageModel>>() {
                    }.getType());

                    //sorting the list to most recent
                    Collections.sort(list, new Comparator<ImageModel>() {
                        public int compare(ImageModel o1, ImageModel o2) {
                            if (o1.getFormattedDate() == null || o2.getFormattedDate() == null)
                                return 0;
                            return o1.getDate().compareTo(o2.getDate());
                        }
                    });

                    return list;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public String loadJSONFromAsset() {
        String json = "";
        try {
            InputStream is;
            is = NasaApp.getNonUIContext().getAssets().open("images.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
