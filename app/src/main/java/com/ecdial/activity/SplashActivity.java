package com.ecdial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

import com.ecdial.R;

import java.nio.file.Path;

public class SplashActivity extends AppCompatActivity {
ImageView ivLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivLogo=findViewById(R.id.ivLogo);
      /*  LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_animation_fall_down);
        rec_offer.setLayoutAnimation(animationController);*/

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_scale_rotate);
        ivLogo.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), RegisterWithMobileActivity.class));
                finish();
            }
        }, 2000);
    }
}