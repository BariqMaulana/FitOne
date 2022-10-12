package com.example.fitone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register_activity extends AppCompatActivity {

    private ImageView buttonBack;

    FirebaseAuth mAuth;

    Button btnRegister;

    EditText etRegEmail, etRegName, etRegPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonBack = (ImageView) findViewById(R.id.backButtonRegister);

        etRegEmail = (EditText) findViewById(R.id.et_reg_email);
        etRegName = (EditText) findViewById(R.id.et_reg_name);
        etRegPassword = (EditText) findViewById(R.id.et_reg_password);



        mAuth = FirebaseAuth.getInstance();

        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(view ->{
            createUser();
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (register_activity.this, login_activity.class);
                startActivity(i);
            }
        });
    }

    private void createUser(){
        String email = etRegEmail.getText().toString();
        String password = etRegPassword.getText().toString();
        String name = etRegName.getText().toString();

        if (TextUtils.isEmpty(email)){
            etRegEmail.setError("Email cannot be empty!");
            etRegEmail.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etRegEmail.setError("Please provide valid email!");
            etRegEmail.requestFocus();
            return;
        } else if (TextUtils.isEmpty(password)){
            etRegPassword.setError("Password cannot be empty!");
            etRegPassword.requestFocus();
            return;
        } else if (password.length() < 6){
            etRegPassword.setError("Password length should be above 5 characters!");
            etRegPassword.requestFocus();
            return;
        } else if (TextUtils.isEmpty(name)){
            etRegName.setError("Username cannot be empty!");
            etRegName.requestFocus();
            return;
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        User user = new User(name, email);

                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser()
                                .getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(register_activity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(register_activity.this, login_activity.class));
                                } else {
                                    Toast.makeText(register_activity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    } else{
                        Toast.makeText(register_activity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}