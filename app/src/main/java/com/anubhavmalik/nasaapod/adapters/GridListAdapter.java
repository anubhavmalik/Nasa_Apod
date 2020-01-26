package com.anubhavmalik.nasaapod.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anubhavmalik.nasaapod.R;
import com.anubhavmalik.nasaapod.databinding.ItemGridListBinding;
import com.anubhavmalik.nasaapod.models.ImageModel;
import com.anubhavmalik.nasaapod.viewmodels.GridActivityViewModel;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class GridListAdapter extends RecyclerView.Adapter<GridListAdapter.GridViewHolder> {
    private MutableLiveData<List<ImageModel>> listMutableLiveData = new MutableLiveData<>();

    public GridListAdapter() {
    }

    public void setListMutableLiveData(MutableLiveData<List<ImageModel>> listMutableLiveData) {
        this.listMutableLiveData = listMutableLiveData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(ItemGridListBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.onBind(Objects.requireNonNull(listMutableLiveData.getValue()).get(position));
    }

    @Override
    public int getItemCount() {
        if(listMutableLiveData.getValue()!=null){
            listMutableLiveData.getValue().size();
        }
        return 0;
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        ItemGridListBinding binding;

        GridViewHolder(@NonNull ItemGridListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void onBind(ImageModel imageModel){
            binding.setImageModel(imageModel);
        }
    }
}
