package com.ecdial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecdial.databinding.RowHomeCatLayoutBinding;
import com.ecdial.databinding.RowOfferLayoutBinding;
import com.ecdial.model.CategoryHome;
import com.ecdial.model.OfferModel;

import java.util.ArrayList;

public class CatHomeAdapter extends RecyclerView.Adapter<CatHomeAdapter.MyViewHolder>{


    private Context mContext;
    private ArrayList<CategoryHome> catList;

    public CatHomeAdapter(Context mContext, ArrayList<CategoryHome> catList) {
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
        CategoryHome modelObject = catList.get(position);
        holder.rowHomeCatLayoutBinding.txCatName.setText(modelObject.getCatName());
        holder.rowHomeCatLayoutBinding.ivCat.setImageResource(modelObject.getCatImage());


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
