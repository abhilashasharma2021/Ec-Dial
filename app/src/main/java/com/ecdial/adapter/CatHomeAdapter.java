package com.ecdial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ecdial.R;
import com.ecdial.databinding.RowHomeCatLayoutBinding;
import com.ecdial.databinding.RowOfferLayoutBinding;
import com.ecdial.model.AllCategoryResponce;
import com.ecdial.model.CategoryHome;
import com.ecdial.model.OfferModel;

import java.util.ArrayList;
import java.util.List;

public class CatHomeAdapter extends RecyclerView.Adapter<CatHomeAdapter.MyViewHolder>{


    private Context mContext;
    private List<AllCategoryResponce.Datum> catList;

    public CatHomeAdapter(Context mContext, List<AllCategoryResponce.Datum> catList) {
        this.mContext = mContext;
        this.catList = catList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowHomeCatLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllCategoryResponce.Datum modelObject = catList.get(position);

        if (!modelObject.equals("")){
            holder.rowHomeCatLayoutBinding.txCatName.setText(modelObject.getCategoryName());


            try {
                Glide.with(mContext).load(modelObject.getIcon())
                        .placeholder(R.drawable.fashion).override(250, 250)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.rowHomeCatLayoutBinding.ivCat);
            } catch (Exception e) {

            }
        }






    }

    @Override
    public int getItemCount() {
        return catList == null ? 0 : catList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowHomeCatLayoutBinding rowHomeCatLayoutBinding;
        public MyViewHolder(RowHomeCatLayoutBinding rowHomeCatLayoutBinding) {
            super(rowHomeCatLayoutBinding.getRoot());
            this.rowHomeCatLayoutBinding = rowHomeCatLayoutBinding;
        }

    }
}
