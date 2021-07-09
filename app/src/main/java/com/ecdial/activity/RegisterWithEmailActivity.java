package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ecdial.MainActivity;
import com.ecdial.R;
import com.ecdial.TermsAndConditionActivity;
import com.ecdial.databinding.ActivityRegisterOrLoginBinding;
import com.ecdial.databinding.ActivityRegisterWithEmailBinding;

public class RegisterWithEmailActivity extends AppCompatActivity {
ActivityRegisterWithEmailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegisterWithEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.txPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterWithEmailActivity.this,RegisterWithMobileActivity.class));
            }
        });


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterWithEmailActivity.this, OtpVerifyActivity.class));
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
                startActivity(new Intent(RegisterWithEmailActivity.this, TermsAndConditionActivity.class));
            }
        });

        binding.txPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterWithEmailActivity.this, PrivacyPolicyActivity.class));
            }
        });
    }
}