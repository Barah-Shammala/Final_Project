package com.example.myfinalproject;

import android.media.Image;

public class Task {
    String taskName;
    String Category;
    String time;
    String Description;
    String hour_s;
    String dayMonth;
    int important;

    public Task(String taskName, String category, String time, String description, String hour_s, String dayMonth, int important) {
        this.taskName = taskName;
        Category = category;
        this.time = time;
        Description = description;
        this.hour_s = hour_s;
        this.dayMonth = dayMonth;
        this.important = important;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getHour_s() {
        return hour_s;
    }

    public void setHour_s(String hour_s) {
        this.hour_s = hour_s;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }
}
