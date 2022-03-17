package com.example.scheduleadmin.ModelClasses;

public class CompletedModelClass {

    String modeImageView,subjectImageView,subjectName,className,sectionName,streamName,teacherImage,teacherName,startTime,endTime;

    public CompletedModelClass(String modeImageView, String subjectImageView, String subjectName, String className, String sectionName, String streamName, String teacherImage, String teacherName, String startTime, String endTime) {
        this.modeImageView = modeImageView;
        this.subjectImageView = subjectImageView;
        this.subjectName = subjectName;
        this.className = className;
        this.sectionName = sectionName;
        this.streamName = streamName;
        this.teacherImage = teacherImage;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getModeImageView() {
        return modeImageView;
    }

    public String getSubjectImageView() {
        return subjectImageView;
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

    public String getTeacherImage() {
        return teacherImage;
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
}
