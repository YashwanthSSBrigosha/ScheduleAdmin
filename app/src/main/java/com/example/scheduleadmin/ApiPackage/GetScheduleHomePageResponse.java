package com.example.scheduleadmin.ApiPackage;

import java.util.List;

public class GetScheduleHomePageResponse{
    public Schedules schedules;
    public List<OccuranceCount> occuranceCounts;
    public List<Subject> subjects;
    public List<Standard> standards;
    public TodaysActivities todaysActivities;
    public List<Mode> modes;

    public GetScheduleHomePageResponse(Schedules schedules, List<OccuranceCount> occuranceCounts, List<Subject> subjects, List<Standard> standards, TodaysActivities todaysActivities, List<Mode> modes) {
        this.schedules = schedules;
        this.occuranceCounts = occuranceCounts;
        this.subjects = subjects;
        this.standards = standards;
        this.todaysActivities = todaysActivities;
        this.modes = modes;
    }

    public Schedules getSchedules() {
        return schedules;
    }

    public List<OccuranceCount> getOccuranceCounts() {
        return occuranceCounts;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Standard> getStandards() {
        return standards;
    }

    public TodaysActivities getTodaysActivities() {
        return todaysActivities;
    }

    public List<Mode> getModes() {
        return modes;
    }
}


