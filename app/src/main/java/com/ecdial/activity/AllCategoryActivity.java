package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ecdial.R;
import com.ecdial.databinding.ActivityAllCategoryBinding;

public class AllCategoryActivity extends AppCompatActivity {
ActivityAllCategoryBinding binding;
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
    }
}