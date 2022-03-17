package com.example.scheduleadmin.ApiPackage;


public class GetSummaryDataResponse {
    public String date;
    public String short_date;
    public int cancelled;
    public int total;
    public int completed;

    public GetSummaryDataResponse(String date, String short_date, int cancelled, int total, int completed) {
        this.date = date;
        this.short_date = short_date;
        this.cancelled = cancelled;
        this.total = total;
        this.completed = completed;
    }

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

