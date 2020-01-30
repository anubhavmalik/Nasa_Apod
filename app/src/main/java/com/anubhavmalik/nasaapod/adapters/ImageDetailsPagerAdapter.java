package com.anubhavmalik.nasaapod.adapters;

import android.os.Bundle;

import com.anubhavmalik.nasaapod.constants.AppConstants;
import com.anubhavmalik.nasaapod.fragments.ImageDetailFragment;
import com.anubhavmalik.nasaapod.repositories.ImageDataRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Created by Anubhav Malik on Wed 29 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class ImageDetailsPagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragmentList = fillFragmentList();

    public ImageDetailsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    private List<Fragment> fillFragmentList() {
        List<Fragment> list = new ArrayList<>();
        for(int i = 0 ; i < ImageDataRepository.getInstance().getImageModelList().size() ; i++){
            list.add(ImageDetailFragment.newInstance(getBundleWithPosition(i)));
        }
        return list;
    }

    private Bundle getBundleWithPosition(int position){
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstants.ADAPTER_POSITION, position);
        return bundle;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

}
