package com.example.fitone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class open_articles extends AppCompatActivity {

    private BottomNavigationItemView exercises, btnAccount;
    private TextView openArticle1, openArticle2, openArticle3;
    ImageSlider imageSlider;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_view);

        exercises = (BottomNavigationItemView) findViewById(R.id.exercises);
        btnAccount = (BottomNavigationItemView) findViewById(R.id.account);
        openArticle1 = (TextView) findViewById(R.id.article_content1);
        openArticle2 = (TextView) findViewById(R.id.article_content2);
        openArticle3 = (TextView) findViewById(R.id.article_content3);
        imageSlider = (ImageSlider) findViewById(R.id.image_slider_article);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();

        exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_articles.this, MainActivity.class);
                startActivity(i);
            }

        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser != null) {
                    Intent i = new Intent (open_articles.this, profile_activity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent (open_articles.this, login_activity.class);
                    startActivity(i);
                }
            }

        });

        openArticle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_articles.this, show_article.class);
                startActivity(i);
            }

        });

        openArticle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_articles.this, show_article2.class);
                startActivity(i);
            }

        });

        openArticle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_articles.this, show_article3.class);
                startActivity(i);
            }

        });

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.healthy_food, null));
        imageList.add(new SlideModel(R.drawable.fruits, null));
        imageList.add(new SlideModel(R.drawable.healthy_food_2, null));
        imageList.add(new SlideModel(R.drawable.fruitsvsnack, null));
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP);
    }
}