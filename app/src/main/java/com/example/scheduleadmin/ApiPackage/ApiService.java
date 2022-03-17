package com.example.scheduleadmin.ApiPackage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTEzMywicGhvbmUiOiIrOTE5ODEyMTY4NTk5IiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJicm93c2VyTG9naW5Db2RlIjoiKzkxOTgxMjE2ODU5OTExMzM3Y2ZiOWE5Ny1iN2FlLTRhMDctYjI2OS0yNmYyZDk3NDczYjUiLCJkZXZpY2VMb2dpbkNvZGUiOm51bGwsImlhdCI6MTY0NjgwMzIxM30.dg4fn5RhRFjohWB94Ao3vHYgXbYpOBBK5CRsZf45OEQ", "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/filter-schedule")
    Call<GetScheduleByParamResponse> SCHEDULE_BY_PARAM_RESPONSE_CALL(@Query("date") String date);

    @Headers({"Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTEzMywicGhvbmUiOiIrOTE5ODEyMTY4NTk5IiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJicm93c2VyTG9naW5Db2RlIjoiKzkxOTgxMjE2ODU5OTExMzM3Y2ZiOWE5Ny1iN2FlLTRhMDctYjI2OS0yNmYyZDk3NDczYjUiLCJkZXZpY2VMb2dpbkNvZGUiOm51bGwsImlhdCI6MTY0NjgwMzIxM30.dg4fn5RhRFjohWB94Ao3vHYgXbYpOBBK5CRsZf45OEQ",
    "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/")
    Call<GetScheduleHomePageResponse> SCHEDULE_HOME_PAGE_RESPONSE_CALL();

    @Headers({
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTEzMywicGhvbmUiOiIrOTE5ODEyMTY4NTk5IiwidXJsIjoidGVzdC50aGVjbGFzc3Jvb20uYml6Iiwib3JnSWQiOiI0Y2IyNTA5ZC03MGY1LTQzNWUtODc5Mi1kMjQ5Mzc3NDNiNTMiLCJicm93c2VyTG9naW5Db2RlIjoiKzkxOTgxMjE2ODU5OTExMzM3Y2ZiOWE5Ny1iN2FlLTRhMDctYjI2OS0yNmYyZDk3NDczYjUiLCJkZXZpY2VMb2dpbkNvZGUiOm51bGwsImlhdCI6MTY0NjgwMzIxM30.dg4fn5RhRFjohWB94Ao3vHYgXbYpOBBK5CRsZf45OEQ", "orgurl:test.theclassroom.biz"})
    @GET("/api/schedule-new/timetable")
    Call<GetTimetableResponse> GET_TIMETABLE_RESPONSE_CALL(@Query("view") String view,@Query("classId") int classId);
}
