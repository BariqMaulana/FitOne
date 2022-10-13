package com.example.fitone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button button, button2, button3, button4, button5, button6, button7, button8;
    private BottomNavigationItemView btnArticles, btnAccount;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnBack);
        button2 = (Button) findViewById(R.id.btnAbs);
        button3 = (Button) findViewById(R.id.btnBiceps);
        button4 = (Button) findViewById(R.id.btnCalf);
        button5 = (Button) findViewById(R.id.btnLegs);
        button6 = (Button) findViewById(R.id.btnChest);
        button7 = (Button) findViewById(R.id.btnTriceps);
        button8 = (Button) findViewById(R.id.btnShoulder);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Back Workouts");
                startActivity(i);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Abs Workouts");
                startActivity(i);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Biceps Workouts");
                startActivity(i);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Calf Workouts");
                startActivity(i);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Legs Workouts");
                startActivity(i);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Chest Workouts");
                startActivity(i);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Triceps Workouts");
                startActivity(i);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_list.class);
                i.putExtra("headerWorkout", "Shoulder Workouts");
                startActivity(i);
            }
        });


        btnArticles = (BottomNavigationItemView) findViewById(R.id.articles);

        btnArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, open_articles.class);
                startActivity(i);
            }


        });

        btnAccount = (BottomNavigationItemView) findViewById(R.id.account);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser != null) {
                    Intent i = new Intent (MainActivity.this, profile_activity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent (MainActivity.this, login_activity.class);
                    startActivity(i);
                }
            }

        });

    }

}