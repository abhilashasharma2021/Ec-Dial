package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ecdial.MainActivity;
import com.ecdial.R;
import com.ecdial.databinding.ActivityHelpBinding;
import com.ecdial.fragment.HomeFrag;

public class HelpActivity extends AppCompatActivity {
ActivityHelpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHelpBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, MainActivity.class));
            }
        });
    }
}