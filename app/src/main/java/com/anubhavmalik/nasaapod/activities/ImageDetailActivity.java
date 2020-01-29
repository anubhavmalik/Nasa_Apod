package com.anubhavmalik.nasaapod.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.anubhavmalik.nasaapod.R;
import com.anubhavmalik.nasaapod.adapters.ImageDetailsPagerAdapter;
import com.anubhavmalik.nasaapod.constants.AppConstants;
import com.anubhavmalik.nasaapod.customviews.ZoomOutPageTransformer;
import com.anubhavmalik.nasaapod.databinding.ActivityImageDetailBinding;
import com.anubhavmalik.nasaapod.viewmodels.ImageDetailActivityViewModel;

public class ImageDetailActivity extends AppCompatActivity {
    private ImageDetailsPagerAdapter imageDetailsPagerAdapter;
    private ActivityImageDetailBinding binding;
    private ImageDetailActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_detail);
        initViewModel();
        initAdapter();
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(ImageDetailActivityViewModel.class);
        binding.setViewModel(viewModel);
    }

    private void initAdapter() {
        imageDetailsPagerAdapter = new ImageDetailsPagerAdapter(this);
        binding.viewPager.setAdapter(imageDetailsPagerAdapter);
        binding.viewPager.setCurrentItem(getSelectedPosition());

        binding.viewPager.setOffscreenPageLimit(3);
        binding.viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        binding.viewPager.canScrollHorizontally(ViewPager2.ORIENTATION_HORIZONTAL);
        binding.viewPager.setPageTransformer(new ZoomOutPageTransformer());
    }

    private int getSelectedPosition(){
        if(getIntent()!=null && getIntent().getExtras()!=null){
            return getIntent().getExtras().getInt(AppConstants.ADAPTER_POSITION);
        }
        return 0;
    }
}
