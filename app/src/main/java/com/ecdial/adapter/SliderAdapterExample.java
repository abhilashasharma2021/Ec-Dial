package com.ecdial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.ecdial.R;
import com.ecdial.model.BannerResponce;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;


public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

    List<BannerResponce.Datum> dataAdapters;

    public SliderAdapterExample(List<BannerResponce.Datum> getDataAdapter, Context context) {
        this.context = context;
        this.dataAdapters = getDataAdapter;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
     final BannerResponce.Datum dataAdapterOBJ = dataAdapters.get(position);

     if (!dataAdapterOBJ.equals("")){

        /*   if(position==0){
            Picasso.get().load(R.drawable.gym).into(viewHolder.imageViewBackground);
        }*/




       try {
             Glide.with(viewHolder.itemView)
                     .load(dataAdapterOBJ.getPicture())
                     .into(viewHolder.imageViewBackground);
         } catch (Exception e) {
             e.printStackTrace();
         }


     }



    }



    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return dataAdapters.size();
    }

    class SliderAdapterVH extends  SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
           // textViewDescription = itemView.findViewById(R.id.txt_details);
            this.itemView = itemView;
        }
    }


}