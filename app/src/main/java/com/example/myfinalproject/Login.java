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

public class Login extends AppCompatActivity {
    ImageView back_icon;
    Button sign_in;
    EditText email_ed,password_ed;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        back_icon= findViewById(R.id.back_icon);
        sign_in = findViewById(R.id.sign_in);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(),MainActivity.class);
                startActivity(in);
            }
        });
        // login //
        password_ed = findViewById(R.id.password);
        email_ed = findViewById(R.id.email);
        auth = FirebaseAuth.getInstance();
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = password_ed.getText().toString();
                String email = email_ed.getText().toString();
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(getBaseContext(),Home_Daily.class);
                            startActivity(in);
                        }
                        else {
                            Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            Log.e("loginTest", "onComplete from login: "+task.getException() );


                        }
                    }
                });

            }
        });
    }
}