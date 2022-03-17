package com.example.scheduleadmin.ApiPackage;

import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class CreateScheduleRequest {
    public int teacherId;
    public int subjectId;
    public List<Integer> classIds;
    public List<String> weekdays;
    public String startTime;
    public String endTime;
    public String mode;
    public String startDate;
    public String endDate;

    public CreateScheduleRequest(int teacherId, int subjectId, List<Integer> classIds, List<String> weekdays, String startTime, String endTime, String mode, String startDate, String endDate) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.classIds = classIds;
        this.weekdays = weekdays;
        this.startTime = startTime;
        this.endTime = endTime;
        this.mode = mode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public List<Integer> getClassIds() {
        return classIds;
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}

