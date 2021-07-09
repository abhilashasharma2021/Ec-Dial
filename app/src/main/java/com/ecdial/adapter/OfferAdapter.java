package com.ecdial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecdial.databinding.RowOfferLayoutBinding;
import com.ecdial.model.OfferBottomSheetModel;
import com.ecdial.model.OfferModel;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder>{


    private Context mContext;
    private ArrayList<OfferModel> offerList;

    public OfferAdapter(Context mContext, ArrayList<OfferModel> offerList) {
        this.mContext = mContext;
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowOfferLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OfferModel modelObject = offerList.get(position);
        holder.rowOfferLayoutBinding.txCatName.setText(modelObject.getCatName());


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
        private RowOfferLayoutBinding rowOfferLayoutBinding;
        public MyViewHolder(RowOfferLayoutBinding rowOfferLayoutBinding) {
            super(rowOfferLayoutBinding.getRoot());
            this.rowOfferLayoutBinding = rowOfferLayoutBinding;
        }

    }
}
