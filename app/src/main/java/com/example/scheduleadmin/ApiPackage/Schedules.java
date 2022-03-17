package com.example.scheduleadmin.ApiPackage;

import java.util.List;

public class Schedules {
    public List<Scheduled> scheduled;
    public List<Ongoing> ongoing;
    public List<Completed> completed;
    public List<Cancelled> cancelled;

    public List<Scheduled> getScheduled() {
        return scheduled;
    }

    public List<Ongoing> getOngoing() {
        return ongoing;
    }

    public List<Completed> getCompleted() {
        return completed;
    }

    public List<Cancelled> getCancelled() {
        return cancelled;
    }
}
