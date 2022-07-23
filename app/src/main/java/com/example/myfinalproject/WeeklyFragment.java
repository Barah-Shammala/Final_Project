package com.example.myfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class WeeklyFragment extends Fragment {
    private ArrayList<Task> tasks;

    public WeeklyFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasks = new ArrayList<>();
        tasks.add(new Task("Metting with Team","Friends","12:00","Have to meet him because i want to show him\n" +
                "my latest app design in person.","AM","28 Feb, 2018",R.drawable.ic_baseline_star_border_24));
        tasks.add(new Task("Launch with Julie","Family","4:00","Bla bla bla","AM","28 Feb, 2018",R.drawable.ic_baseline_star_border_24));
        tasks.add(new Task("Go to Pharmecy","Health","6:00","Bla bla bla","AM","28 Feb, 2018",R.drawable.ic_baseline_star_border_24));
        View v = inflater.inflate(R.layout.fragment_weekly, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.tasks_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new Task_ListAdapter(tasks,getActivity()));
        return v;
    }
}