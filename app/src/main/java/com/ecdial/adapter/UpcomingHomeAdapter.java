package com.ecdial.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ecdial.R;
import com.ecdial.databinding.RowhomebrandlayoutBinding;
import com.ecdial.databinding.RowupcominghomelayoutBinding;
import com.ecdial.model.AllBrandsResponce;
import com.ecdial.model.AllUpcomingResponce;

import java.util.List;

public class UpcomingHomeAdapter extends RecyclerView.Adapter<UpcomingHomeAdapter.MyViewHolder>{


    private Context mContext;
    private List<AllUpcomingResponce.Datum> upcomingList;

    public UpcomingHomeAdapter(Context mContext, List<AllUpcomingResponce.Datum> upcomingList) {
        this.mContext = mContext;
        this.upcomingList = upcomingList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowupcominghomelayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllUpcomingResponce.Datum modelObject = upcomingList.get(position);
        holder.rowupcominghomelayoutBinding.txBrandName.setText(modelObject.getProductName());
               holder.rowupcominghomelayoutBinding.txSellPrice.setText(modelObject.getProductVariantSellingPrice());
        holder.rowupcominghomelayoutBinding.txSellPrice.setPaintFlags( holder.rowupcominghomelayoutBinding.txSellPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.rowupcominghomelayoutBinding.txOfferPrice.setText("₹"+modelObject.getProductVariantOfferPrice());


        holder.rowupcominghomelayoutBinding.txOffPercent.setText(modelObject.getProductVariantDiscount()+"% off");


       try {
            Glide.with(mContext).load(modelObject.getPicture())
                    .placeholder(R.drawable.fashion).override(250, 250)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.rowupcominghomelayoutBinding.ivBrand);
        } catch (Exception e) {

        }




    }

    @Override
    public int getItemCount() {
        return upcomingList == null ? 0 : upcomingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowupcominghomelayoutBinding rowupcominghomelayoutBinding;
        public MyViewHolder(RowupcominghomelayoutBinding rowupcominghomelayoutBinding) {
            super(rowupcominghomelayoutBinding.getRoot());
            this.rowupcominghomelayoutBinding = rowupcominghomelayoutBinding;
        }

    }
}
