package com.example.scheduleadmin.ApiPackage;

import java.util.List;

public class GetScheduleByParamResponse {

        public List<Scheduled> scheduled;
        public List<Ongoing> ongoing;
        public List<Completed> completed;
        public List<Cancelled> cancelled;

    public GetScheduleByParamResponse(List<Scheduled> scheduled, List<Ongoing> ongoing, List<Completed> completed, List<Cancelled> cancelled) {
        this.scheduled = scheduled;
        this.ongoing = ongoing;
        this.completed = completed;
        this.cancelled = cancelled;
    }

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

