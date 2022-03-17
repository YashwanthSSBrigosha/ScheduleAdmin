package com.example.scheduleadmin.ApiPackage;

public class ShowDeleteSchedule {
    public String type;
    public String message;

    public ShowDeleteSchedule(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
