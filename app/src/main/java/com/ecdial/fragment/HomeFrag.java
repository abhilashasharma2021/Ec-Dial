package com.ecdial.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecdial.MainActivity;
import com.ecdial.R;
import com.ecdial.databinding.FragmentHomeBinding;


public class HomeFrag extends Fragment {

FragmentHomeBinding binding;
View view;
Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(getLayoutInflater(),container,false);
        view=binding.getRoot();
        context=getActivity();

       binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.drawerlayout.openDrawer(GravityCompat.START);
            }
        });


        return view;
    }
}