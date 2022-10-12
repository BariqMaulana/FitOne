package com.example.fitone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {

    private ImageView btnBack;
    private EditText ETemail;
    private Button btnResetPassword;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnBack = (ImageView) findViewById(R.id.backButtonForgotPass);
        ETemail = (EditText) findViewById(R.id.et_enter_email);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);

        mAuth = FirebaseAuth.getInstance();

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(forgot_password.this, login_activity.class);
                startActivity((i));
            }
        });
    }

    private void resetPassword() {
        String email = ETemail.getText().toString();

        if (email.isEmpty()) {
            ETemail.setError("Email is required!");
            ETemail.requestFocus();
        }

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                
                if (task.isSuccessful()) {
                    Toast.makeText(forgot_password.this, "Check your email to reset your password!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(forgot_password.this, "Error! Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}