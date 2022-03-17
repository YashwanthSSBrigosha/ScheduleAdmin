package com.example.scheduleadmin.ApiPackage;

public class TodaysActivities {
    public int scheduled;
    public int cancelled;
    public int completed;
    public int ongoing;

    public TodaysActivities(int scheduled, int cancelled, int completed, int ongoing) {
        this.scheduled = scheduled;
        this.cancelled = cancelled;
        this.completed = completed;
        this.ongoing = ongoing;
    }

    public int getScheduled() {
        return scheduled;
    }

    public int getCancelled() {
        return cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public int getOngoing() {
        return ongoing;
    }
}
