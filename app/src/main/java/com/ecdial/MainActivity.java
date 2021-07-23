package com.ecdial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecdial.activity.AllBrandsActivity;
import com.ecdial.activity.AllCategoryActivity;
import com.ecdial.activity.HelpActivity;
import com.ecdial.activity.PrivacyPolicyActivity;
import com.ecdial.activity.SplashActivity;
import com.ecdial.fragment.HomeFrag;
import com.ecdial.fragment.ProfileFrag;
import com.ecdial.sharedhelper.Appconstant;
import com.ecdial.sharedhelper.SharedHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    NavigationView nav_view;
    public static DrawerLayout drawerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);


        drawerlayout = findViewById(R.id.drawerlayout);
        nav_view = findViewById(R.id.nav_view);

        View headerView = nav_view.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFrag()).commit();
                drawerlayout.closeDrawer(GravityCompat.START);
            }
        });


        bottomNav.setOnNavigationItemSelectedListener(this);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.category){
                    startActivity(new Intent(MainActivity.this, AllCategoryActivity.class));
                    drawerlayout.closeDrawer(GravityCompat.START);


                }
             else  if (item.getItemId()==R.id.privacy){
                    startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
                    drawerlayout.closeDrawer(GravityCompat.START);


                }

                else  if (item.getItemId()==R.id.brands){
                    startActivity(new Intent(MainActivity.this, AllBrandsActivity.class));
                    drawerlayout.closeDrawer(GravityCompat.START);
                }

                else  if (item.getItemId()==R.id.terms){
                    startActivity(new Intent(MainActivity.this, TermsAndConditionActivity.class));
                    drawerlayout.closeDrawer(GravityCompat.START);
                }

                else  if (item.getItemId()==R.id.help){
                    startActivity(new Intent(MainActivity.this, HelpActivity.class));
                    drawerlayout.closeDrawer(GravityCompat.START);
                }

                else  if (item.getItemId()==R.id.logout){
                    logout();
                    drawerlayout.closeDrawer(GravityCompat.START);


                }




                return false;
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFrag()).commit();
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_cat:

                startActivity(new Intent(MainActivity.this, AllCategoryActivity.class));
                drawerlayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFrag()).commit();
                drawerlayout.closeDrawer(GravityCompat.START);
                break;

        }

        return true;
    }
    public void logout() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.logout_dialog);
        dialog.setCancelable(true);
        Button btn_yes = dialog.findViewById(R.id.btn_yes);
        Button btn_no = dialog.findViewById(R.id.btn_no);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                finish();
               /* SharedHelper.putKey(getApplicationContext(), Appconstant.USERID, "");
                startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                finish();*/
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }
}