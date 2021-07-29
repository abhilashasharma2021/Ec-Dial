package com.ecdial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.ecdial.ProgressBarCustom.CustomDialog;
import com.ecdial.databinding.ActivityTermsAndConditionBinding;
import com.ecdial.model.TermsModel;
import com.ecdial.utils.APIDATA;

import static com.ecdial.utils.APIDATA.terms_Condition;

public class TermsAndConditionActivity extends AppCompatActivity {
ActivityTermsAndConditionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTermsAndConditionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        terms_Conditions();
    }


    private void terms_Conditions(){

        CustomDialog dialog=new CustomDialog();
        dialog.showDialog(R.layout.progress_layout, TermsAndConditionActivity.this);

        AndroidNetworking.post(APIDATA.BASE_URL)
                .addQueryParameter("Auth","eyJhdXRoIjp7ImRpZ2VzdCI6IlpEUXdZVGt5WmpVeU1EVm1NelJsT1dReE1qazFZbUV5TTJJM1l6ZzFZVFZqTTJSak5ERXlPUT09IiwidXNlcm5hbWUiOiJ0cGluX2FuZHJvaWRfZ3BzdXNlciIsInRpbWVzdGFtcCI6IjIwMTctMTItMDggMTI6Mzc6MTgifX0=")
                .addQueryParameter("Case",terms_Condition)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(TermsModel.class, new ParsedRequestListener<TermsModel>() {
                    @Override
                    public void onResponse(TermsModel response) {
                        Log.e("fdfdgvfdvb", "response: " +response);
                        dialog.hideDialog();

                        if (!response.getData().isEmpty()){
                          binding.text.setText(response.getData().get(0).getTermsAndCondition());
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("fdfdgvfdvb", "onError: " +anError.getMessage());
                        dialog.hideDialog();
                    }
                });



    }



}