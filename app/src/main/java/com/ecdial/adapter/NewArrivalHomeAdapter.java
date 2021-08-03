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
import com.ecdial.databinding.RownewarrivalhomelayoutBinding;
import com.ecdial.databinding.RowupcominghomelayoutBinding;
import com.ecdial.model.AllUpcomingResponce;
import com.ecdial.model.NewArrivalsModel;

import java.util.List;

public class NewArrivalHomeAdapter extends RecyclerView.Adapter<NewArrivalHomeAdapter.MyViewHolder>{


    private Context mContext;
    private List<NewArrivalsModel.Datum> newArrivalsList;

    public NewArrivalHomeAdapter(Context mContext, List<NewArrivalsModel.Datum> newArrivalsList) {
        this.mContext = mContext;
        this.newArrivalsList = newArrivalsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RownewarrivalhomelayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewArrivalsModel.Datum modelObject = newArrivalsList.get(position);

        if (!modelObject.equals("")){

            holder.rownewarrivalhomelayoutBinding.txNewName.setText(modelObject.getProductName());
            try {
                Glide.with(mContext).load(modelObject.getPicture())
                        .placeholder(R.drawable.fashion).override(250, 250)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.rownewarrivalhomelayoutBinding.ivNew);
            } catch (Exception e) {

            }
        }





    }

    @Override
    public int getItemCount() {
        return newArrivalsList == null ? 0 : newArrivalsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RownewarrivalhomelayoutBinding rownewarrivalhomelayoutBinding;
        public MyViewHolder(RownewarrivalhomelayoutBinding rownewarrivalhomelayoutBinding) {
            super(rownewarrivalhomelayoutBinding.getRoot());
            this.rownewarrivalhomelayoutBinding = rownewarrivalhomelayoutBinding;
        }

    }
}
