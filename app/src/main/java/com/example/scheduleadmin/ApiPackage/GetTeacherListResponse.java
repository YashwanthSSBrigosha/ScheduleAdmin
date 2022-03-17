package com.example.scheduleadmin.ApiPackage;


public class GetTeacherListResponse {
    public int id;
    public String name;

    public GetTeacherListResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


