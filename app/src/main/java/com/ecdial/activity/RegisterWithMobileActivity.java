package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ecdial.MainActivity;
import com.ecdial.R;
import com.ecdial.TermsAndConditionActivity;
import com.ecdial.databinding.ActivityRegisterOrLoginBinding;

public class RegisterWithMobileActivity extends AppCompatActivity {
ActivityRegisterOrLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityRegisterOrLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterWithMobileActivity.this, OtpVerifyActivity.class));
            }
        });

        binding.ivCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

        binding.txTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterWithMobileActivity.this, TermsAndConditionActivity.class));
            }
        });

        binding.txPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterWithMobileActivity.this, PrivacyPolicyActivity.class));
            }
        });
    }
}