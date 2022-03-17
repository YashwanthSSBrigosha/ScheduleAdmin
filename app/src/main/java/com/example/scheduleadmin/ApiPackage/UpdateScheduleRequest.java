package com.example.scheduleadmin.ApiPackage;

import java.util.List;

public class UpdateScheduleRequest {
        public int scheduleId;
        public int teacherId;
        public int subjectId;
        public List<Integer> classIds;
        public List<String> weekdays;
        public String startTime;
        public String endTime;
        public String mode;
        public String startDate;
        public String endDate;

    public UpdateScheduleRequest(int scheduleId, int teacherId, int subjectId, List<Integer> classIds, List<String> weekdays, String startTime, String endTime, String mode, String startDate, String endDate) {
        this.scheduleId = scheduleId;
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

    public int getScheduleId() {
        return scheduleId;
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

