package com.example.fitone;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class open_workout extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 60000;

    private ImageView back;
    private VideoView videov;
    private TextView timer;
    private Button btnStartPause, btnReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_view);

        timer = findViewById(R.id.timer);

        ring = MediaPlayer.create(open_workout.this, R.raw.ring);

        btnStartPause = findViewById(R.id.button_start_pause);
        btnReset = findViewById(R.id.button_reset);
        videov = findViewById(R.id.displayWorkout);
        back = (ImageView) findViewById(R.id.backButton);

        String videopath = "android.resource://com.example.fitone/" + R.raw.pullupexercise;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videov.setMediaController(mediaController);
        mediaController.setAnchorView(videov);

        updateCountDownText();

        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning){
                    pauseTimer();
                } else{
                    startTimer();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                btnStartPause.setText("Pause");
                btnStartPause.setVisibility(View.INVISIBLE);
                btnReset.setVisibility(View.VISIBLE);
                ring.start();
            }
        } .start();
        mTimerRunning = true;
        btnStartPause.setText("Pause");
        btnReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        btnStartPause.setText("Start");
        btnReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        btnReset.setVisibility(View.INVISIBLE);
        btnStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        timer.setText(timeLeftFormatted);
    }
}