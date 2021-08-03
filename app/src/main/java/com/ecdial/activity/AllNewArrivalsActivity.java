package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.ecdial.ProgressBarCustom.CustomDialog;
import com.ecdial.R;
import com.ecdial.adapter.AllNewArrivalAdapter;
import com.ecdial.databinding.ActivityAllNewArrivalsBinding;
import com.ecdial.model.NewArrivalsModel;
import com.ecdial.utils.APIDATA;

import java.util.ArrayList;

import static com.ecdial.utils.APIDATA.show_NewArrivals;

public class AllNewArrivalsActivity extends AppCompatActivity {
    ActivityAllNewArrivalsBinding binding;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllNewArrivalsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        showAllNew_Arrivals();

        binding.swipeRefreshLayout.setOnRefreshListener(() ->    binding.swipeRefreshLayout.postDelayed(() -> {
            binding.swipeRefreshLayout.setRefreshing(false);
            showAllNew_Arrivals();
        }, 2000));



    }


    private void showAllNew_Arrivals() {
        CustomDialog dialog=new CustomDialog();
        dialog.showDialog(R.layout.progress_layout,AllNewArrivalsActivity.this);
        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth", "eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                .addQueryParameter("Case", show_NewArrivals)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(NewArrivalsModel.class, new ParsedRequestListener<NewArrivalsModel>() {
                    @Override
                    public void onResponse(NewArrivalsModel response) {
                        Log.e("HomeFrag", "onResponse: " + response);
                         dialog.hideDialog();
                        if (!response.getData().isEmpty()) {

                            binding.rvArrivals.setHasFixedSize(true);
                            layoutManager = new GridLayoutManager(AllNewArrivalsActivity.this, 2, RecyclerView.VERTICAL, false);
                            binding.rvArrivals.setLayoutManager(layoutManager);
                            AllNewArrivalAdapter adapter = new AllNewArrivalAdapter(AllNewArrivalsActivity.this, response.getData());
                            binding.rvArrivals.setAdapter(adapter);

                            }

                        }

                        @Override
                    public void onError(ANError anError) {
                        Log.e("HomeFrag", "onError: " + anError.getMessage());
                            dialog.hideDialog();
                    }
                });

    }
}