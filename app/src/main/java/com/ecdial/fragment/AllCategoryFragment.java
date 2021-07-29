package com.ecdial.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
import com.ecdial.adapter.ShowAllCategoryAdapter;
import com.ecdial.databinding.FragmentAllCategoryBinding;
import com.ecdial.model.AllCategoryResponce;
import com.ecdial.utils.APIDATA;

import static com.ecdial.utils.APIDATA.show_category;


public class AllCategoryFragment extends Fragment {

   FragmentAllCategoryBinding binding;
   View view;
   Context context;
    RecyclerView.LayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentAllCategoryBinding.inflate(getLayoutInflater(),container, false);
        view=binding.getRoot();
        context = getActivity();


        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });


        show_Category();

        binding.swipeRefreshLayout.setOnRefreshListener(() ->binding.swipeRefreshLayout.postDelayed(() -> {
            binding.swipeRefreshLayout.setRefreshing(false);
            show_Category();
        }, 2000));


        return  view;


    }

    private  void show_Category() {

        CustomDialog dialog=new CustomDialog();
        dialog.showDialog(R.layout.progress_layout,getActivity());
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
                            layoutManager = new GridLayoutManager(getActivity(),2, RecyclerView.VERTICAL, false);
                            binding.rvCat.setLayoutManager(layoutManager);
                            ShowAllCategoryAdapter adapter= new ShowAllCategoryAdapter(getActivity(), response.getData());
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