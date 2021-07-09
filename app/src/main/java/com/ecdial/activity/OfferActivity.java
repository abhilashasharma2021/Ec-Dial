package com.ecdial.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ecdial.R;
import com.ecdial.adapter.OfferAdapter;
import com.ecdial.adapter.OfferBottomSheetAdapter;
import com.ecdial.adapter.OfferHoriAdapter;
import com.ecdial.model.OfferBottomSheetModel;
import com.ecdial.model.OfferModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class OfferActivity extends AppCompatActivity {
    BottomSheetBehavior sheetBehavior;
    RecyclerView.LayoutManager layoutManagerBottom, layoutManagerOffer, layoutManagerHoriOffer;
    ArrayList<OfferBottomSheetModel> bottomSheetList = new ArrayList<>();
    OfferBottomSheetAdapter bottomOfferAdapter;
    OfferAdapter offerAdapter;
    OfferHoriAdapter horiOfferAdapter;
    RecyclerView rvOfferBottom, rvOffer, rvHorizontal;
    ArrayList<OfferModel> offerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        RelativeLayout layoutBottomSheet = findViewById(R.id.bottom_sheet);
        RelativeLayout rlOffer = findViewById(R.id.rlOffer);
        rvOfferBottom = findViewById(R.id.rvOfferBottom);
        rvHorizontal = findViewById(R.id.rvHorizontal);
        rvOffer = findViewById(R.id.rvOffer);
       sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);


        rvHorizontal.setHasFixedSize(true);
        layoutManagerHoriOffer = new LinearLayoutManager(OfferActivity.this, RecyclerView.HORIZONTAL, false);
        rvHorizontal.setLayoutManager(layoutManagerHoriOffer);
        horiOfferAdapter = new OfferHoriAdapter(OfferActivity.this, bottomSheetList);
        rvHorizontal.setAdapter(horiOfferAdapter);


        rvOffer.setHasFixedSize(true);
        layoutManagerOffer = new GridLayoutManager(OfferActivity.this, 2, RecyclerView.VERTICAL, false);
        rvOffer.setLayoutManager(layoutManagerOffer);
        offerAdapter = new OfferAdapter(OfferActivity.this, offerList);
        rvOffer.setAdapter(offerAdapter);


      rvOfferBottom.setHasFixedSize(true);
        layoutManagerBottom = new LinearLayoutManager(OfferActivity.this, RecyclerView.VERTICAL, false);
        rvOfferBottom.setLayoutManager(layoutManagerBottom);
        bottomOfferAdapter = new OfferBottomSheetAdapter(OfferActivity.this, bottomSheetList);
        rvOfferBottom.setAdapter(bottomOfferAdapter);

        showOfferBottom();
        showOffer();


        rlOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet();


            }
        });


    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            // btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //btnBottomSheet.setText("Expand sheet");
        }
    }

    private void showOfferBottom() {

        OfferBottomSheetModel model = new OfferBottomSheetModel("Deal Of The day", R.drawable.discount);

        for (int i = 0; i < 6; i++) {
            bottomSheetList.add(model);
        }
    }

    private void showOffer() {

        OfferModel modelOffer = new OfferModel("Fashion", R.drawable.fashion);

        for (int i = 0; i < 6; i++) {
            offerList.add(modelOffer);
        }
    }


}