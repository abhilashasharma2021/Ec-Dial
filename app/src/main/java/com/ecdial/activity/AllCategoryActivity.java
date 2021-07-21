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
import com.baoyz.widget.PullRefreshLayout;
import com.ecdial.ProgressBarCustom.CustomDialog;
import com.ecdial.R;
import com.ecdial.adapter.ShowAllCategoryAdapter;
import com.ecdial.databinding.ActivityAllCategoryBinding;
import com.ecdial.model.AllCategoryResponce;
import com.ecdial.utils.APIDATA;

import java.util.ArrayList;

import static com.ecdial.utils.APIDATA.show_category;

public class AllCategoryActivity extends AppCompatActivity {
ActivityAllCategoryBinding binding;
 RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        show_Category();

        binding.swipeRefreshLayout.setOnRefreshListener(() ->binding.swipeRefreshLayout.postDelayed(() -> {
            binding.swipeRefreshLayout.setRefreshing(false);
            show_Category();
        }, 2000));



    }


  private  void show_Category() {

      CustomDialog dialog=new CustomDialog();
      dialog.showDialog(R.layout.progress_layout,AllCategoryActivity.this);
      AndroidNetworking.post(APIDATA.BASE_URL)
              .addQueryParameter("Auth","eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
              .addQueryParameter("Case",show_category)
              .setPriority(Priority.HIGH)
              .build()
              .getAsObject(AllCategoryResponce.class, new ParsedRequestListener<AllCategoryResponce>() {
                  @Override
                  public void onResponse(AllCategoryResponce response) {
                      Log.e("check", "response: " +response.getData().get(0).getCategoryName());
                      dialog.hideDialog();
                      if (!response.getData().isEmpty()){
                          binding.rvCat.setHasFixedSize(true);
                          layoutManager = new GridLayoutManager(AllCategoryActivity.this,2, RecyclerView.VERTICAL, false);
                          binding.rvCat.setLayoutManager(layoutManager);
                          ShowAllCategoryAdapter  adapter= new ShowAllCategoryAdapter(AllCategoryActivity.this, response.getData());
                          binding.rvCat.setAdapter(adapter);
                      }

                  }

                  @Override
                  public void onError(ANError anError) {
                      dialog.hideDialog();
                  }
              });


    }


    }

