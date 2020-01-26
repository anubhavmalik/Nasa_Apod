package com.anubhavmalik.nasaapod.activities;

import android.os.Bundle;

import com.anubhavmalik.nasaapod.R;
import com.anubhavmalik.nasaapod.adapters.GridListAdapter;
import com.anubhavmalik.nasaapod.databinding.ActivityMainBinding;
import com.anubhavmalik.nasaapod.viewmodels.GridActivityViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private GridActivityViewModel viewModel;
    private GridListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViewModel();
        initAdapter();
        setDataInAdapter();
    }

    private void setDataInAdapter() {
        adapter.setListMutableLiveData(viewModel.getMutableLiveData());
    }

    private void initAdapter() {
        adapter = new GridListAdapter();
        binding.gridRv.setAdapter(adapter);
        binding.gridRv.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(GridActivityViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }
}
