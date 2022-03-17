package com.example.scheduleadmin.ModelClasses;

public class TimeTableModelClass {
    private int mode;
    private String subjectName,teacherName,startTime,endTime;

    public TimeTableModelClass(int mode, String subjectName, String teacherName, String startTime, String endTime) {
        this.mode = mode;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
