package com.ecdial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ecdial.R;
import com.ecdial.databinding.RowAllBrandsLayoutBinding;
import com.ecdial.databinding.RowhomebrandlayoutBinding;
import com.ecdial.model.AllBrandsResponce;

import java.util.List;

public class BrandsHomeAdapter extends RecyclerView.Adapter<BrandsHomeAdapter.MyViewHolder>{


    private Context mContext;
    private List<AllBrandsResponce.Datum> brandlist;

    public BrandsHomeAdapter(Context mContext, List<AllBrandsResponce.Datum> brandlist) {
        this.mContext = mContext;
        this.brandlist = brandlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowhomebrandlayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllBrandsResponce.Datum modelObject = brandlist.get(position);
        holder.rowhomebrandlayoutBinding.txBrandName.setText(modelObject.getBrandName());



       try {
            Glide.with(mContext).load(modelObject.getPicture())
                    .placeholder(R.drawable.fashion).override(250, 250)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.rowhomebrandlayoutBinding.ivBrand);
        } catch (Exception e) {

        }




    }

    @Override
    public int getItemCount() {
        return brandlist == null ? 0 : brandlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowhomebrandlayoutBinding rowhomebrandlayoutBinding;
        public MyViewHolder(RowhomebrandlayoutBinding rowhomebrandlayoutBinding) {
            super(rowhomebrandlayoutBinding.getRoot());
            this.rowhomebrandlayoutBinding = rowhomebrandlayoutBinding;
        }

    }
}
