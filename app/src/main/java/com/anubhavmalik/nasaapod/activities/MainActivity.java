package com.anubhavmalik.nasaapod.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.anubhavmalik.nasaapod.BR;
import com.anubhavmalik.nasaapod.R;
import com.anubhavmalik.nasaapod.databinding.ActivityMainBinding;
import com.anubhavmalik.nasaapod.viewmodels.GridActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private GridActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViewModel();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(GridActivityViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }
}
