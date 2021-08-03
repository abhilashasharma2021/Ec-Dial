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
import com.ecdial.databinding.RowallnewarrivallayoutBinding;
import com.ecdial.model.NewArrivalsModel;

import java.util.List;

public class AllNewArrivalAdapter extends RecyclerView.Adapter<AllNewArrivalAdapter.MyViewHolder>{


    private Context mContext;
    private List<NewArrivalsModel .Datum> newArrivalsList;

    public AllNewArrivalAdapter(Context mContext, List<NewArrivalsModel .Datum> newArrivalsList) {
        this.mContext = mContext;
        this.newArrivalsList = newArrivalsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowallnewarrivallayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewArrivalsModel .Datum modelObject = newArrivalsList.get(position);

        if (!modelObject.equals("")){
            holder.rowallnewarrivallayoutBinding.txName.setText(modelObject.getProductName());
            holder.rowallnewarrivallayoutBinding.txSellPrice.setText(modelObject.getProductVariantSellingPrice());
            holder.rowallnewarrivallayoutBinding.txSellPrice.setPaintFlags( holder.rowallnewarrivallayoutBinding.txSellPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            holder.rowallnewarrivallayoutBinding.txOfferPrice.setText("₹"+modelObject.getProductVariantOfferPrice());


            holder.rowallnewarrivallayoutBinding.txOffPercent.setText(modelObject.getProductVariantDiscount()+"% off");


            try {
                Glide.with(mContext).load(modelObject.getPicture())
                        .placeholder(R.drawable.fashion).override(250, 250)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.rowallnewarrivallayoutBinding.ivArrival);
            } catch (Exception e) {

            }

        }




    }

    @Override
    public int getItemCount() {
        return newArrivalsList == null ? 0 : newArrivalsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowallnewarrivallayoutBinding rowallnewarrivallayoutBinding;
        public MyViewHolder(RowallnewarrivallayoutBinding rowallnewarrivallayoutBinding) {
            super(rowallnewarrivallayoutBinding.getRoot());
            this.rowallnewarrivallayoutBinding = rowallnewarrivallayoutBinding;
        }

    }
}
