package com.anubhavmalik.nasaapod.adapters.clicklisteners;

import com.anubhavmalik.nasaapod.models.ImageModel;

/**
 * Created by Anubhav Malik on Mon 27 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public interface GridClickListener {
    void onItemClicked(ImageModel imageModel, int position);
}
