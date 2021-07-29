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
import com.ecdial.databinding.RowofferhomelayoutBinding;
import com.ecdial.databinding.RowupcominghomelayoutBinding;
import com.ecdial.model.AllUpcomingResponce;
import com.ecdial.model.OfferResponce;

import java.util.List;

public class OfferHomeAdapter extends RecyclerView.Adapter<OfferHomeAdapter.MyViewHolder>{


    private Context mContext;
    private List<OfferResponce.Datum> offerList;

    public OfferHomeAdapter(Context mContext, List<OfferResponce.Datum> offerList) {
        this.mContext = mContext;
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowofferhomelayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OfferResponce.Datum modelObject = offerList.get(position);
        holder.rowofferhomelayoutBinding.txBrandName.setText(modelObject.getProductOfferName());
        holder.rowofferhomelayoutBinding.txOfferEndDate.setText("End Offer Date :"+modelObject.getProductOfferEndDate());
        holder.rowofferhomelayoutBinding.txOfferEndTime.setText("End Offer Time :"+modelObject.getProductOfferEndTime());




       /*try {
            Glide.with(mContext).load(modelObject.getPicture())
                    .placeholder(R.drawable.fashion).override(250, 250)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.rowofferhomelayoutBinding.ivBrand);
        } catch (Exception e) {

        }*/




    }

    @Override
    public int getItemCount() {
        return offerList == null ? 0 : offerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowofferhomelayoutBinding rowofferhomelayoutBinding;
        public MyViewHolder(RowofferhomelayoutBinding rowofferhomelayoutBinding) {
            super(rowofferhomelayoutBinding.getRoot());
            this.rowofferhomelayoutBinding = rowofferhomelayoutBinding;
        }

    }
}
