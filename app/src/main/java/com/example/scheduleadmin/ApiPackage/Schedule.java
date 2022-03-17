package com.example.scheduleadmin.ApiPackage;

import java.util.List;

public class Schedule {
    public int id;
    public List<String> weekdays;
    public String startTime;
    public String endTime;
    public String mode;
    public Teacher teacher;
    public Subject subject;
    public List<Standard> standards;
    public String startDate;
    public String endDate;

    public int getId() {
        return id;
    }

    public List<String> getWeekdays() {
        return weekdays;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getMode() {
        return mode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public List<Standard> getStandards() {
        return standards;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
