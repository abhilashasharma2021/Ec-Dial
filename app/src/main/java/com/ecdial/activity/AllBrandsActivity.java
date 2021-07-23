package com.ecdial.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.baoyz.widget.PullRefreshLayout;
import com.ecdial.R;
import com.ecdial.adapter.ShowAllBrandsAdapter;
import com.ecdial.model.AllBrandsResponce;
import com.ecdial.utils.APIDATA;

import static com.ecdial.utils.APIDATA.show_brands;


public class AllBrandsActivity extends AppCompatActivity {
RecyclerView.LayoutManager layoutManager;
ImageView ivBack;
PullRefreshLayout swipeRefreshLayout;
RecyclerView rvBrands;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_all_brands);

        ivBack = findViewById(R.id.ivBack);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        rvBrands = findViewById(R.id.rvBrands);



        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


      show_Brands();

       swipeRefreshLayout.setOnRefreshListener(() ->swipeRefreshLayout.postDelayed(() -> {
           swipeRefreshLayout .setRefreshing(false);
         show_Brands();
        }, 2000));


    }


    private  void show_Brands() {
        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth","eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                .addQueryParameter("Case",show_brands)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(AllBrandsResponce.class, new ParsedRequestListener<AllBrandsResponce>() {
                    @Override
                    public void onResponse(AllBrandsResponce response) {

                        Log.e("AllBrandsActivity", "onResponse: " +response.getData().get(0).getBrandName());

                       if (!response.getData().isEmpty()){
                          rvBrands.setHasFixedSize(true);
                            layoutManager = new GridLayoutManager(AllBrandsActivity.this,2, RecyclerView.VERTICAL, false);
                          rvBrands.setLayoutManager(layoutManager);
                            ShowAllBrandsAdapter adapter= new ShowAllBrandsAdapter(AllBrandsActivity.this, response.getData());
                           rvBrands.setAdapter(adapter);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("AllBrandsActivity", "onError: " +anError);

                    }
                });


    }
}