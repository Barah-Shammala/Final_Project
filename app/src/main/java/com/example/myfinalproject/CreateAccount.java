package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {
    ImageView back_icon;
    EditText fullName_ed,password_ed,email_ed,phone_ed;
    Button sign_up;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        back_icon= findViewById(R.id.back_icon);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(),MainActivity.class);
                startActivity(in);
            }
        });
        fullName_ed =findViewById(R.id.full_name);
        password_ed = findViewById(R.id.password);
        email_ed = findViewById(R.id.email);
        phone_ed = findViewById(R.id.phone);
        sign_up = findViewById(R.id.sign_up_btn);
        auth = FirebaseAuth.getInstance();
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = fullName_ed.getText().toString();
                String email = email_ed.getText().toString();
                String password = password_ed.getText().toString();
                String confirm_pass = phone_ed.getText().toString();
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(CreateAccount.this, "Register is successfully", Toast.LENGTH_SHORT).show();
                            
                            Intent in = new Intent(getApplicationContext(),Login.class);
                            startActivity(in);
                        }
                        else {
                            Toast.makeText(CreateAccount.this, "Register failed", Toast.LENGTH_SHORT).show();
                            Log.e("registerTest", "onComplete: "+task.getException() );

                        }
                    }
                });
            }
        });

    }
}