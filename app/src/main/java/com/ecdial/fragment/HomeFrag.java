package com.ecdial.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.ecdial.MainActivity;
import com.ecdial.ProgressBarCustom.CustomDialog;
import com.ecdial.R;
import com.ecdial.adapter.CatHomeAdapter;
import com.ecdial.adapter.SliderAdapterExample;
import com.ecdial.databinding.FragmentHomeBinding;
import com.ecdial.model.BannerResponce;
import com.ecdial.model.CategoryHome;
import com.ecdial.utils.APIDATA;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import static com.ecdial.utils.APIDATA.show_banners;


public class HomeFrag extends Fragment {

    FragmentHomeBinding binding;
    View view;
    Context context;
    RecyclerView.LayoutManager layoutManager;
    List<BannerResponce.Datum> listOfSlider = new ArrayList<>();
    ArrayList<CategoryHome> catList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        view = binding.getRoot();
        context = getActivity();

        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.drawerlayout.openDrawer(GravityCompat.START);
            }
        });

        binding.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.CUBEOUTROTATIONTRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(3);
        binding.imageSlider.startAutoCycle();


        binding.rvCat.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        binding.rvCat.setLayoutManager(layoutManager);
        CatHomeAdapter adapter = new CatHomeAdapter(getActivity(), catList);
        binding.rvCat.setAdapter(adapter);

        show_Category();
        showBanner();
        return view;
    }


    private void showBanner() {


        CustomDialog dialog=new CustomDialog();
        dialog.showDialog(R.layout.progress_layout,getActivity());
        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth","eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                 .addQueryParameter("Case",show_banners)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(BannerResponce.class, new ParsedRequestListener<BannerResponce>() {

                    @Override
                    public void onResponse(BannerResponce response) {
                        dialog.hideDialog();
                        listOfSlider=new ArrayList<>();
                        if (!response.getData().isEmpty()){

                            SliderAdapterExample sliderAdapter = new SliderAdapterExample(response.getData(), getActivity());
                            binding.imageSlider.setSliderAdapter(sliderAdapter);


                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.hideDialog();
                    }
                });
    }

    private void show_Category() {
        CategoryHome model = new CategoryHome("Fashion", R.drawable.fashion);
        for (int i = 0; i < 12; i++) {
            catList.add(model);
        }

    }


}