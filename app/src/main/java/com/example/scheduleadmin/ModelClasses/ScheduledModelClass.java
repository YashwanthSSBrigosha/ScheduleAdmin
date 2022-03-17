package com.example.scheduleadmin.ModelClasses;

public class ScheduledModelClass {
    String modeImage,subjectImage,subjectName,className,sectionName,streamName,teacherImage,teacherName,startTime,endTime;

    public ScheduledModelClass(String modeImage, String subjectImage, String subjectName, String className, String sectionName, String streamName, String teacherImage, String teacherName, String startTime, String endTime) {
        this.modeImage = modeImage;
        this.subjectImage = subjectImage;
        this.subjectName = subjectName;
        this.className = className;
        this.sectionName = sectionName;
        this.streamName = streamName;
        this.teacherImage = teacherImage;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getModeImage() {
        return modeImage;
    }

    public String getSubjectImage() {
        return subjectImage;
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
