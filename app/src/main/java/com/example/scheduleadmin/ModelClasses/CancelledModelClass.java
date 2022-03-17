package com.example.scheduleadmin.ModelClasses;

public class CancelledModelClass {

    String subjectName, className, sectionName, streamName, teacherName, startTime, endTime, modeImage, subjectImage, teacherImage;

    public CancelledModelClass(String subjectName, String className, String sectionName, String streamName, String teacherName, String startTime, String endTime, String modeImage, String subjectImage, String teacherImage) {
        this.subjectName = subjectName;
        this.className = className;
        this.sectionName = sectionName;
        this.streamName = streamName;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.modeImage = modeImage;
        this.subjectImage = subjectImage;
        this.teacherImage = teacherImage;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassName() {
        return className;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getStreamName() {
        return streamName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getModeImage() {
        return modeImage;
    }

    public String getSubjectImage() {
        return subjectImage;
    }

    public String getTeacherImage() {
        return teacherImage;
    }
}
