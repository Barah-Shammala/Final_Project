package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Done extends AppCompatActivity {
    private ArrayList<Task> tasks;
    ImageView back_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        tasks = new ArrayList<>();
        tasks.add(new Task("Metting with Team","Friends","12:00","Have to meet him because i want to show him\n" +
                "my latest app design in person.","AM","28 Feb, 2018",R.drawable.ic_baseline_star_border_24));
        tasks.add(new Task("Launch with Julie","Family","4:00","Bla bla bla","AM","28 Feb, 2018",R.drawable.ic_baseline_star_border_24));
        tasks.add(new Task("Go to Pharmecy","Health","6:00","Bla bla bla","AM","28 Feb, 2018",R.drawable.ic_baseline_star_border_24));
        RecyclerView recyclerView = findViewById(R.id.tasks_rv);
        RecyclerView recyclerView1 = findViewById(R.id.tasks_rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(Done.this));
        recyclerView.setAdapter(new Task_ListAdapter(tasks,Done.this));
        back_icon = findViewById(R.id.done_task_backIcon);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getBaseContext(),Home_Daily.class);
                startActivity(in);
            }
        });
    }
}