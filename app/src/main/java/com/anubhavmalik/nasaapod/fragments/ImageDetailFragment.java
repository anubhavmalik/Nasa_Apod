package com.anubhavmalik.nasaapod.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.anubhavmalik.nasaapod.R;
import com.anubhavmalik.nasaapod.constants.AppConstants;
import com.anubhavmalik.nasaapod.databinding.FragmentImageDetailBinding;
import com.anubhavmalik.nasaapod.viewmodels.ImageDetailFragmentViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by Anubhav Malik on Tue 28 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class ImageDetailFragment extends Fragment {
    private ImageDetailFragmentViewModel imageDetailFragmentViewModel;
    private FragmentImageDetailBinding binding;

    public static Fragment newInstance(Bundle bundle) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_detail, container, false);
        initViewModel();
        setupUI();
        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupUI() {
        binding.imageDetailExplanation.setMovementMethod(new ScrollingMovementMethod());

        binding.imageDetailExplanation.scrollTo(0,0);

        binding.imageDetailHdImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (binding.imageDetailHdImage.getCurrentScaleFactor() > 1f || binding.imageDetailHdImage.getCurrentScaleFactor() < 1f) {
                    binding.imageDetailHdImage.setTranslatable(true);
                } else {
                    binding.imageDetailHdImage.setTranslatable(false);
                }

                return binding.imageDetailHdImage.onTouchEvent(event);
            }
        });
    }

    private void initViewModel() {
        imageDetailFragmentViewModel = ViewModelProviders.of(this).get(ImageDetailFragmentViewModel.class);
        int position = getPositionFromBundle();
        if (position == -1) {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        } else {
            imageDetailFragmentViewModel.initializeImageModelFromPosition(position);
            binding.setViewModel(imageDetailFragmentViewModel);
        }
    }

    private int getPositionFromBundle() {
        if (getArguments() != null)
            return getArguments().getInt(AppConstants.ADAPTER_POSITION);
        else
            return -1;
    }
}
