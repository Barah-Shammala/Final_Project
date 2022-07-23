package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class task_detailes extends AppCompatActivity {
    TextView task_de_name,task_de_date,task_de_desc,task_de_cate2;
    ImageView back_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detailes);
        task_de_name = findViewById(R.id.task_de_name);
        task_de_date = findViewById(R.id.task_de_date);
        task_de_desc = findViewById(R.id.task_de_desc);
        task_de_cate2= findViewById(R.id.task_de_cate2);
        Intent i = getIntent();
        String name = i.getStringExtra("taskName");
        String hour = i.getStringExtra("taskTime");
        String Description = i.getStringExtra("taskDesc");
        String Category = i.getStringExtra("taskCag");
        task_de_name.setText(name);
        task_de_date.setText(hour);
        task_de_desc.setText(Description);
        task_de_cate2.setText(Category);
        back_icon = findViewById(R.id.task_de_backIcon);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(),Home_Daily.class);
                startActivity(in);
            }
        });
    }
}