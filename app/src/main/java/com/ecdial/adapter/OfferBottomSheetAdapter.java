package com.ecdial.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.ecdial.R;
import com.ecdial.databinding.RowOfferBottomShitLayoutBinding;
import com.ecdial.model.OfferBottomSheetModel;

import java.util.ArrayList;
import java.util.List;

public class OfferBottomSheetAdapter extends RecyclerView.Adapter<OfferBottomSheetAdapter.MyViewHolder>{


    private Context mContext;
    private ArrayList<OfferBottomSheetModel> bottomSheetList;

    public OfferBottomSheetAdapter(Context mContext, ArrayList<OfferBottomSheetModel> bottomSheetList) {
        this.mContext = mContext;
        this.bottomSheetList = bottomSheetList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowOfferBottomShitLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OfferBottomSheetModel modelObject = bottomSheetList.get(position);
        holder.rowOfferBottomShitLayoutBinding.txCatName.setText(modelObject.getTitle());


       /* try {
            Glide.with(mContext).load(modelObject.getCoursePath() + modelObject.getCourseImage())
                    .placeholder(R.drawable.dummy).override(250, 250)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.rowOfferBottomShitLayoutBinding.ivCourse);
        } catch (Exception e) {

        }*/




    }

    @Override
    public int getItemCount() {
        return bottomSheetList == null ? 0 : bottomSheetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowOfferBottomShitLayoutBinding rowOfferBottomShitLayoutBinding;
        public MyViewHolder(RowOfferBottomShitLayoutBinding rowOfferBottomShitLayoutBinding) {
            super(rowOfferBottomShitLayoutBinding.getRoot());
            this.rowOfferBottomShitLayoutBinding = rowOfferBottomShitLayoutBinding;
        }

    }
}
