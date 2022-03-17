package com.example.scheduleadmin.ApiPackage;

import java.util.Date;
import java.util.List;

public class Ongoing {
    public int id;
    public String startTime;
    public String endTime;
    public String status;
    public int teacherId;
    public int subjectId;
    public String mode;
    public int scheduleId;
    public String date;
    public String roomName;
    public boolean firstJoined;
    public Date updatedAt;
    public Date createdAt;
    public Teacher teacher;
    public List<Standard> standards;
    public Subject subject;
    public Schedule schedule;
    public ZoomMeetingDetails zoomMeetingDetails;

    public int getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
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

    public int getScheduleId() {
        return scheduleId;
    }

    public String getDate() {
        return date;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isFirstJoined() {
        return firstJoined;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Standard> getStandards() {
        return standards;
    }

    public Subject getSubject() {
        return subject;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public ZoomMeetingDetails getZoomMeetingDetails() {
        return zoomMeetingDetails;
    }
}
