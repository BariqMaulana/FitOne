package com.example.fitone;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class open_list extends AppCompatActivity {

    private BottomNavigationItemView btnExercises, btnArticles, btnAccount;
    private ImageView btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        btnExercises = (BottomNavigationItemView) findViewById(R.id.exercises);

        btnExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnArticles = (BottomNavigationItemView) findViewById(R.id.articles);

        btnArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_articles.class);
                startActivity(i);
            }
        });


        btnStart = (ImageView) findViewById(R.id.startWorkoutBtn);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_workout.class);
                startActivity(i);
            }
        });

        btnAccount = (BottomNavigationItemView) findViewById(R.id.account);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, login_activity.class);
                startActivity(i);
            }


        });

    }
}