package com.example.scheduleadmin.ApiPackage;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class GetTimetableResponse {
    public String weekday;
    public ArrayList<Object> occurances;
}



