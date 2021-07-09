package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ecdial.MainActivity;
import com.ecdial.R;
import com.ecdial.databinding.ActivityOtpVerifyBinding;

public class OtpVerifyActivity extends AppCompatActivity {
ActivityOtpVerifyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpVerifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtpVerifyActivity.this, OtpVerifyActivity.class));
            }
        });

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtpVerifyActivity.this, MainActivity.class));
            }
        });
    }
}