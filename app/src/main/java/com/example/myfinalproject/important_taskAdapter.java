package com.example.myfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class important_taskAdapter extends RecyclerView.Adapter<important_taskAdapter.importantViewHolder> {
    ArrayList<Task> important_tasks;
    Context context;

    public important_taskAdapter(ArrayList<Task> important_tasks, Context context) {
        this.important_tasks = important_tasks;
        this.context = context;
    }

    @NonNull
    @Override
    public importantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.custom_list_important,parent,false);
        important_taskAdapter.importantViewHolder im_tViewHolder = new important_taskAdapter.importantViewHolder(v);
        return im_tViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull importantViewHolder holder, int position) {
        Task t = important_tasks.get(position);
        holder.hour.setText(t.getTime());
        holder.task_name.setText(t.getTaskName());
        holder.task_category.setText(t.getCategory());
        holder.daily_hour_s.setText(t.getHour_s());
        holder.daily_task_dec.setText(t.getDescription());
    }

    @Override
    public int getItemCount() {
        return important_tasks.size();
    }

    class importantViewHolder extends RecyclerView.ViewHolder{
        TextView hour,task_name,task_category,daily_hour_s,daily_task_dec,full_date;
        ImageView important_icon;
        public importantViewHolder(@NonNull View itemView) {
            super(itemView);
            hour = itemView.findViewById(R.id.daily_hour);
            task_name = itemView.findViewById(R.id.daily_task_name);
            task_category = itemView.findViewById(R.id.daily_task_category);
            daily_hour_s = itemView.findViewById(R.id.daily_hour_s);
            daily_task_dec = itemView.findViewById(R.id.daily_task_dec);
            full_date = itemView.findViewById(R.id.daily_dateTime);
            important_icon = itemView.findViewById(R.id.important_task_rating);
        }
    }
}
