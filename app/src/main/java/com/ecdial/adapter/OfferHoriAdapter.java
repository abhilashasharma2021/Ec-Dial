package com.ecdial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecdial.databinding.RowOfferHoriLayoutBinding;

import com.ecdial.model.OfferBottomSheetModel;


import java.util.ArrayList;

public class OfferHoriAdapter extends RecyclerView.Adapter<OfferHoriAdapter.MyViewHolder>{


    private Context mContext;
    private ArrayList<OfferBottomSheetModel> offerList;

    public OfferHoriAdapter(Context mContext, ArrayList<OfferBottomSheetModel> offerList) {
        this.mContext = mContext;
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowOfferHoriLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OfferBottomSheetModel modelObject = offerList.get(position);
        holder.rowOfferHoriLayoutBinding.txCatName.setText(modelObject.getTitle());


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
        return offerList == null ? 0 : offerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowOfferHoriLayoutBinding rowOfferHoriLayoutBinding;
        public MyViewHolder(RowOfferHoriLayoutBinding rowOfferHoriLayoutBinding) {
            super(rowOfferHoriLayoutBinding.getRoot());
            this.rowOfferHoriLayoutBinding = rowOfferHoriLayoutBinding;
        }

    }
}
