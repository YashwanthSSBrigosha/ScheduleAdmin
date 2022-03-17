package com.example.scheduleadmin.ApiPackage;

public class OccuranceCount {
    public String date;
    public String short_date;
    public int cancelled;
    public int total;
    public int completed;

    public String getDate() {
        return date;
    }

    public String getShort_date() {
        return short_date;
    }

    public int getCancelled() {
        return cancelled;
    }

    public int getTotal() {
        return total;
    }

    public int getCompleted() {
        return completed;
    }
}
