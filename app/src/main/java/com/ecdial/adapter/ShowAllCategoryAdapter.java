package com.ecdial.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ecdial.R;
import com.ecdial.databinding.RowCateoryLayoutBinding;
import com.ecdial.model.AllCategoryResponce;

import java.util.List;

public class ShowAllCategoryAdapter extends RecyclerView.Adapter<ShowAllCategoryAdapter.MyViewHolder>{


    private Context mContext;
    private List<AllCategoryResponce.Datum> catList;

    public ShowAllCategoryAdapter(Context mContext, List<AllCategoryResponce.Datum> catList) {
        this.mContext = mContext;
        this.catList = catList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowCateoryLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllCategoryResponce.Datum modelObject = catList.get(position);
        holder.rowCateoryLayoutBinding.txCatName.setText(modelObject.getCategoryName());


        Log.e("ShowAllCategoryAdapter", "onBindViewHolder: " +modelObject.getCategoryName());
        Log.e("ShowAllCategoryAdapter", "onBindViewHolder: " +modelObject.getIcon());

       try {
            Glide.with(mContext).load(modelObject.getIcon())
                    .placeholder(R.drawable.fashion).override(250, 250)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.rowCateoryLayoutBinding.ivCat);
        } catch (Exception e) {

        }




    }

    @Override
    public int getItemCount() {
        return catList == null ? 0 : catList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowCateoryLayoutBinding rowCateoryLayoutBinding;
        public MyViewHolder(RowCateoryLayoutBinding rowCateoryLayoutBinding) {
            super(rowCateoryLayoutBinding.getRoot());
            this.rowCateoryLayoutBinding = rowCateoryLayoutBinding;
        }

    }
}
