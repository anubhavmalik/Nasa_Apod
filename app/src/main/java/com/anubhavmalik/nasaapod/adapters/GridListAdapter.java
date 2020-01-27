package com.anubhavmalik.nasaapod.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.anubhavmalik.nasaapod.adapters.clicklisteners.GridClickListener;
import com.anubhavmalik.nasaapod.databinding.ItemGridListBinding;
import com.anubhavmalik.nasaapod.models.ImageModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Anubhav Malik on Sun 26 Jan,2020
 * Copyright (c) 2020 Socnet Technologies Pvt Ltd
 * All rights reserved.
 */
public class GridListAdapter extends RecyclerView.Adapter<GridListAdapter.GridViewHolder> {
    private List<ImageModel> list = new ArrayList<>();
    private GridClickListener gridClickListener;

    public GridClickListener getGridClickListener() {
        return gridClickListener;
    }

    public void setGridClickListener(GridClickListener gridClickListener) {
        this.gridClickListener = gridClickListener;
    }

    public GridListAdapter() {
    }

    public void setList(List<ImageModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(ItemGridListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        Log.d("recyclerPosition", position + "");
        return super.getItemId(position);
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ItemGridListBinding binding;

        GridViewHolder(@NonNull ItemGridListBinding binding) {
            super(binding.getRoot());
            Log.d("recyclerPosition", getAdapterPosition() + "");

            this.binding = binding;
        }

        void onBind(ImageModel imageModel) {

            if (gridClickListener != null)
                imageModel.setGridClickListener(gridClickListener);

            binding.setImageModel(imageModel);

            binding.executePendingBindings();
        }
    }
}
