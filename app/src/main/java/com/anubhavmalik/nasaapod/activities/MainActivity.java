package com.anubhavmalik.nasaapod.activities;

import android.os.Bundle;

import com.anubhavmalik.nasaapod.R;
import com.anubhavmalik.nasaapod.adapters.GridListAdapter;
import com.anubhavmalik.nasaapod.adapters.clicklisteners.GridClickListener;
import com.anubhavmalik.nasaapod.databinding.ActivityMainBinding;
import com.anubhavmalik.nasaapod.models.ImageModel;
import com.anubhavmalik.nasaapod.viewmodels.GridActivityViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity implements GridClickListener {
    private ActivityMainBinding binding;
    private GridActivityViewModel viewModel;
    private GridListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViewModel();
        setDataInAdapter();
    }

    private void setDataInAdapter() {
        viewModel.getMutableLiveData().observe(this, new Observer<List<ImageModel>>() {
            @Override
            public void onChanged(List<ImageModel> imageModels) {
                if (adapter == null)
                    initAdapter(imageModels);
            }
        });
    }

    private void initAdapter(List<ImageModel> imageModels) {
        adapter = new GridListAdapter();
        adapter.setList(imageModels);
        adapter.setGridClickListener(this);

        binding.gridRv.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
        binding.gridRv.setAdapter(adapter);
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(GridActivityViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }

    @Override
    public void onItemClicked(ImageModel imageModel, int position) {
        //todo: open another activity with shared transition

    }
}
