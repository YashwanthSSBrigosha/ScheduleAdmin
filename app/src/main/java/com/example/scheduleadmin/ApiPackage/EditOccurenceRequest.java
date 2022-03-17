package com.example.scheduleadmin.ApiPackage;

import java.util.List;


public class EditOccurenceRequest {
    public int id;
    public String startTime;
    public String endTime;
    public int teacherId;
    public int subjectId;
    public String mode;
    public List<Integer> classIds;

    public EditOccurenceRequest(int id, String startTime, String endTime, int teacherId, int subjectId, String mode, List<Integer> classIds) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.mode = mode;
        this.classIds = classIds;
    }

    public int getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getMode() {
        return mode;
    }

    public List<Integer> getClassIds() {
        return classIds;
    }
}


