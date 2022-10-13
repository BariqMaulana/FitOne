package com.example.fitone;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class open_list extends AppCompatActivity {

    private BottomNavigationItemView btnExercises, btnArticles, btnAccount;
    private ImageView btnStart, btnStart2, btnStart3, btnStart4, btnStart5, btnStart6;
    private TextView tvHeadWorkout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        tvHeadWorkout = (TextView) findViewById(R.id.header_workout);
        btnExercises = (BottomNavigationItemView) findViewById(R.id.exercises);
        btnArticles = (BottomNavigationItemView) findViewById(R.id.articles);
        btnStart = (ImageView) findViewById(R.id.startWorkoutBtn);
        btnStart2 = (ImageView) findViewById(R.id.startWorkoutBtn2);
        btnStart3 = (ImageView) findViewById(R.id.startWorkoutBtn3);
        btnStart4 = (ImageView) findViewById(R.id.startWorkoutBtn4);
        btnStart5 = (ImageView) findViewById(R.id.startWorkoutBtn5);
        btnStart6 = (ImageView) findViewById(R.id.startWorkoutBtn6);
        btnAccount = (BottomNavigationItemView) findViewById(R.id.account);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();

        Intent intent =getIntent();
        String txt =intent.getStringExtra("headerWorkout");
        tvHeadWorkout.setText(txt);



        btnExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_articles.class);
                startActivity(i);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_workout.class);
                startActivity(i);
            }
        });

        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_workout2.class);
                startActivity(i);
            }
        });

        btnStart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_workout3.class);
                startActivity(i);
            }
        });

        btnStart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_workout4.class);
                startActivity(i);
            }
        });

        btnStart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_workout5.class);
                startActivity(i);
            }
        });

        btnStart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (open_list.this, open_workout6.class);
                startActivity(i);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser != null) {
                    Intent i = new Intent (open_list.this, profile_activity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent (open_list.this, login_activity.class);
                    startActivity(i);
                }
            }

        });

    }
}