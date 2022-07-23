package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImportantTask extends AppCompatActivity {
    private ArrayList<Task> tasks;
    ImageView back_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_task);
        tasks = new ArrayList<>();
        tasks.add(new Task("Important Task","Important","12:00",
                "Important Task Description"
                ,"AM","28 Feb, 2018",R.drawable.yallow_star));
        tasks.add(new Task("Important Task","Important","12:00",
                "Important Task Description"
                ,"AM","28 Feb, 2018",R.drawable.yallow_star));
        tasks.add(new Task("Important Task","Important","12:00",
                "Important Task Description"
                ,"AM","28 Feb, 2018",R.drawable.yallow_star));
        tasks.add(new Task("Important Task","Important","12:00",
                "Important Task Description"
                ,"AM","28 Feb, 2018",R.drawable.ic_baseline_search_24));
        RecyclerView recyclerView = findViewById(R.id.important_tasks_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(ImportantTask.this));
        recyclerView.setAdapter(new Task_ListAdapter(tasks,ImportantTask.this));
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