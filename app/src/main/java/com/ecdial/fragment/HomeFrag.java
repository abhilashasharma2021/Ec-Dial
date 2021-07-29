package com.ecdial.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.ecdial.MainActivity;
import com.ecdial.ProgressBarCustom.CustomDialog;
import com.ecdial.R;
import com.ecdial.activity.AllBrandsActivity;
import com.ecdial.activity.AllUpcomingActivity;
import com.ecdial.activity.SplashActivity;
import com.ecdial.adapter.BrandsHomeAdapter;
import com.ecdial.adapter.CatHomeAdapter;
import com.ecdial.adapter.OfferHomeAdapter;
import com.ecdial.adapter.SliderAdapterExample;
import com.ecdial.adapter.UpcomingHomeAdapter;
import com.ecdial.databinding.FragmentHomeBinding;
import com.ecdial.model.AllBrandsResponce;
import com.ecdial.model.AllCategoryResponce;
import com.ecdial.model.AllUpcomingResponce;
import com.ecdial.model.BannerResponce;
import com.ecdial.model.OfferResponce;
import com.ecdial.utils.APIDATA;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import static com.ecdial.utils.APIDATA.show_banners;
import static com.ecdial.utils.APIDATA.show_brands;
import static com.ecdial.utils.APIDATA.show_category;
import static com.ecdial.utils.APIDATA.show_offer;
import static com.ecdial.utils.APIDATA.show_upcoming;


public class HomeFrag extends Fragment {

    FragmentHomeBinding binding;
    View view;
    Context context;
    RecyclerView.LayoutManager layoutManager,layoutManagerUpcoming,layoutManagerOffer;
    List<BannerResponce.Datum> listOfSlider = new ArrayList<>();

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

        binding.menuCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity(). getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AllCategoryFragment()).commit();
                Animatoo.animateSwipeRight(getActivity());

            }
        });


        binding.btViewBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllBrandsActivity.class));
                Animatoo.animateSwipeRight(getActivity());

            }
        });


        binding.btUpcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllUpcomingActivity.class));
                Animatoo.animateSwipeRight(getActivity());

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


        show_Category();
        showBanner();
        show_Upcoming();
        show_Offers();

        onBack(view);
        show_Brands();


        return view;
    }


    private void showBanner() {
        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth", "eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                .addQueryParameter("Case", show_banners)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(BannerResponce.class, new ParsedRequestListener<BannerResponce>() {

                    @Override
                    public void onResponse(BannerResponce response) {

                        listOfSlider = new ArrayList<>();
                        if (!response.getData().isEmpty()) {

                            SliderAdapterExample sliderAdapter = new SliderAdapterExample(response.getData(), getActivity());
                            binding.imageSlider.setSliderAdapter(sliderAdapter);


                        }


                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }


    private void show_Category() {


        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth", "eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                .addQueryParameter("Case", show_category)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(AllCategoryResponce.class, new ParsedRequestListener<AllCategoryResponce>() {
                    @Override
                    public void onResponse(AllCategoryResponce response) {
                        Log.e("check", "response: " + response.getData().get(0).getCategoryName());

                        if (!response.getData().isEmpty()) {
                            binding.rvCat.setHasFixedSize(true);
                            layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                            binding.rvCat.setLayoutManager(layoutManager);
                            CatHomeAdapter adapter = new CatHomeAdapter(getActivity(), response.getData());
                            binding.rvCat.setAdapter(adapter);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });


    }

    private void show_Brands() {
        CustomDialog dialog = new CustomDialog();
        dialog.showDialog(R.layout.progress_layout, getActivity());
        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth", "eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                .addQueryParameter("Case", show_brands)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(AllBrandsResponce.class, new ParsedRequestListener<AllBrandsResponce>() {
                    @Override
                    public void onResponse(AllBrandsResponce response) {
                        dialog.hideDialog();
                        Log.e("AllBrandsActivity", "onResponse: " + response.getData().get(0).getBrandName());
                        if (!response.getData().isEmpty()) {
                            ArrayList<AllBrandsResponce.Datum> brandList = new ArrayList<>();
                            if (response.getData().size() > 4) {
                                for (int i = 0; i < 4; i++) {

                                    brandList.add(response.getData().get(i));

                                }

                                binding.rvBrand.setHasFixedSize(true);
                                layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                                binding.rvBrand.setLayoutManager(layoutManager);
                                BrandsHomeAdapter adapter = new BrandsHomeAdapter(getActivity(), brandList);
                                binding.rvBrand.setAdapter(adapter);

                            }


                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AllBrandsActivity", "onError: " + anError);
                        dialog.hideDialog();
                    }
                });


    }

        private void show_Upcoming() {
            AndroidNetworking.post(APIDATA.BASE_URL)
                    .addQueryParameter("Auth", "eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                    .addQueryParameter("Case", show_upcoming)
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsObject(AllUpcomingResponce.class, new ParsedRequestListener<AllUpcomingResponce>() {
                        @Override
                        public void onResponse(AllUpcomingResponce response) {

                            Log.e("ghfhh", "onResponse: " + response.getData().get(0).getProductName());
                            if (!response.getData().isEmpty()) {
                                ArrayList<AllUpcomingResponce.Datum> upcomingList = new ArrayList<>();
                                if (response.getData().size() > 4) {
                                    for (int i = 0; i < 4; i++) {

                                        upcomingList.add(response.getData().get(i));

                                    }

                                    binding.rvUpcoming.setHasFixedSize(true);
                                    layoutManagerUpcoming = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                                    binding.rvUpcoming.setLayoutManager(layoutManagerUpcoming);
                                    UpcomingHomeAdapter adapter = new UpcomingHomeAdapter(getActivity(), upcomingList);
                                    binding.rvUpcoming.setAdapter(adapter);

                                }


                            }

                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.e("AllBrandsActivity", "onError: " + anError);

                        }
                    });


        }
            private void show_Offers() {
                AndroidNetworking.post(APIDATA.BASE_URL)
                        .addQueryParameter("Auth", "eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                        .addQueryParameter("Case", show_offer)
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsObject(OfferResponce.class, new ParsedRequestListener<OfferResponce>() {
                            @Override
                            public void onResponse(OfferResponce response) {

                                if (!response.getData().isEmpty()) {


                                        binding.rvOffer.setHasFixedSize(true);
                                       layoutManagerOffer = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                                        binding.rvOffer.setLayoutManager(layoutManagerOffer);
                                        OfferHomeAdapter adapter = new OfferHomeAdapter(getActivity(), response.getData());
                                        binding.rvOffer.setAdapter(adapter);

                                    }


                                }



                            @Override
                            public void onError(ANError anError) {
                                Log.e("rgrthtr", "onError: " + anError);

                            }
                        });









            }


    public void onBack(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {



                    final Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialogexitlayout);
                    dialog.setCancelable(true);
                    Button btn_yes = dialog.findViewById(R.id.btn_yes);
                    Button btn_no = dialog.findViewById(R.id.btn_no);

                    btn_yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getActivity(), SplashActivity.class));
               /* SharedHelper.putKey(getApplicationContext(), Appconstant.USERID, "");
                startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                finish();*/
                        }
                    });

                    btn_no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });


                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                }

                   /* AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Do you want to exit?");
                    builder.setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {
                            getActivity().finishAffinity();
                        }
                    }).setNegativeButton("No", new android.content.DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();*/


                return true;
            }
        });

    }
}