package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.ecdial.MainActivity;
import com.ecdial.ProgressBarCustom.CustomDialog;
import com.ecdial.R;
import com.ecdial.adapter.ShowAllUpcomingAdapter;
import com.ecdial.adapter.UpcomingHomeAdapter;
import com.ecdial.databinding.ActivityAllUpcomingBinding;
import com.ecdial.model.AllUpcomingResponce;
import com.ecdial.utils.APIDATA;

import java.util.ArrayList;



public class AllUpcomingActivity extends AppCompatActivity {
ActivityAllUpcomingBinding binding;
RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllUpcomingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllUpcomingActivity.this, MainActivity.class));
            }
        });



        show_AllUpcoming();

        binding.swipeRefreshLayout.setOnRefreshListener(() ->  binding.swipeRefreshLayout.postDelayed(() -> {
            binding.swipeRefreshLayout.setRefreshing(false);
            show_AllUpcoming();
        }, 2000));

    }




    private void show_AllUpcoming() {
        CustomDialog dialog = new CustomDialog();
        dialog.showDialog(R.layout.progress_layout, AllUpcomingActivity.this);
        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth", "eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
               /* .addQueryParameter("Case", show_upcoming)*/
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(AllUpcomingResponce.class, new ParsedRequestListener<AllUpcomingResponce>() {
                    @Override
                    public void onResponse(AllUpcomingResponce response) {
                        dialog.hideDialog();
                        Log.e("ghfhh", "onResponse: " + response.getData().get(0).getProductName());
                        if (!response.getData().isEmpty()) {

                            binding.rvUpcoming.setHasFixedSize(true);
                            layoutManager = new GridLayoutManager(AllUpcomingActivity.this,2, RecyclerView.VERTICAL, false);
                            binding.rvUpcoming.setLayoutManager(layoutManager);
                            ShowAllUpcomingAdapter adapter = new ShowAllUpcomingAdapter(AllUpcomingActivity.this, response.getData());
                            binding.rvUpcoming.setAdapter(adapter);


                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AllBrandsActivity", "onError: " + anError);
                        dialog.hideDialog();
                    }
                });


    }



    }