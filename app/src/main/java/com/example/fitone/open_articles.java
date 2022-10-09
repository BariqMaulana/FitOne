package com.example.fitone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import java.util.ArrayList;

public class open_articles extends AppCompatActivity {

    private BottomNavigationItemView item, btnAccount;
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_view);

        item = (BottomNavigationItemView) findViewById(R.id.exercises);

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        btnAccount = (BottomNavigationItemView) findViewById(R.id.account);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_articles.this, login_activity.class);
                startActivity(i);
            }

        });

        imageSlider = (ImageSlider) findViewById(R.id.image_slider_article);

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.healthy_food, null));
        imageList.add(new SlideModel(R.drawable.fruits, null));
        imageList.add(new SlideModel(R.drawable.healthy_food_2, null));
        imageList.add(new SlideModel(R.drawable.fruitsvsnack, null));
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP);
    }
}