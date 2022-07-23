package com.example.myfinalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Task_ListAdapter extends RecyclerView.Adapter<Task_ListAdapter.taskViewHolder>{
    ArrayList<Task> tasks;
    Context context;

    public Task_ListAdapter(ArrayList<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    @NonNull
    @Override
    public taskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.custom_list,parent,false);
        taskViewHolder t_viewHolder = new taskViewHolder(v);
        return t_viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull taskViewHolder holder, int position) {
        Task t = tasks.get(position);
        holder.hour.setText(t.getTime());
        holder.task_name.setText(t.getTaskName());
        holder.task_category.setText(t.getCategory());
        holder.daily_hour_s.setText(t.getHour_s());
        holder.daily_task_dec.setText(t.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,task_detailes.class);
                intent.putExtra("taskName",holder.task_name.getText().toString());
                intent.putExtra("taskTime", holder.full_date + " | "+ holder.hour.getText().toString() + " " + holder.daily_hour_s.getText().toString());
                intent.putExtra("taskDesc",holder.daily_task_dec.getText().toString());
                intent.putExtra("taskCag",holder.task_category.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class taskViewHolder extends RecyclerView.ViewHolder {
        TextView hour,task_name,task_category,daily_hour_s,daily_task_dec,full_date;
        public taskViewHolder(@NonNull View itemView) {
            super(itemView);
            hour = itemView.findViewById(R.id.daily_hour);
            task_name = itemView.findViewById(R.id.daily_task_name);
            task_category = itemView.findViewById(R.id.daily_task_category);
            daily_hour_s = itemView.findViewById(R.id.daily_hour_s);
            daily_task_dec = itemView.findViewById(R.id.daily_task_dec);
            full_date = itemView.findViewById(R.id.daily_dateTime);
        }
    }
}
