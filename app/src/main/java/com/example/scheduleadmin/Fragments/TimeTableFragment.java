package com.example.scheduleadmin.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheduleadmin.AdaptersClasses.TimeTableCardAdapter;
import com.example.scheduleadmin.ApiPackage.ApiClient;
import com.example.scheduleadmin.ApiPackage.ApiService;
import com.example.scheduleadmin.ApiPackage.GetTimetableResponse;
import com.example.scheduleadmin.ModelClasses.TimeTableModelClass;
import com.example.scheduleadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeTableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeTableFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View timeTableView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mondayRV, tuesdayRV, wednesdayRV, thursdayRV, fridayRV, saturdayRV, sundayRV;
    private TimeTableCardAdapter timeTableCardAdapter;
    private ArrayList<TimeTableModelClass> modelClassArrayList;
    private FloatingActionButton fabButton;
    private Retrofit retrofit;
    private ApiService apiService;

    public TimeTableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeTableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeTableFragment newInstance(String param1, String param2) {
        TimeTableFragment fragment = new TimeTableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    private void buildRecyclerView() {
        recViewMon();
        recViewTue();
        recViewWed();
        recViewThu();
        recViewFri();
        recViewSat();
        recViewSun();

    }

    private void recViewSun() {

        sundayRV.setHasFixedSize(true);
        sundayRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        sundayRV.setAdapter(timeTableCardAdapter);
    }

    private void recViewSat() {

        saturdayRV.setHasFixedSize(true);
        saturdayRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        saturdayRV.setAdapter(timeTableCardAdapter);
    }

    private void recViewFri() {
        fridayRV.setHasFixedSize(true);
        fridayRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        fridayRV.setAdapter(timeTableCardAdapter);
    }

    private void recViewThu() {
        thursdayRV.setHasFixedSize(true);
        thursdayRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        thursdayRV.setAdapter(timeTableCardAdapter);

    }

    private void recViewWed() {
        wednesdayRV.setHasFixedSize(true);
        wednesdayRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        wednesdayRV.setAdapter(timeTableCardAdapter);

    }

    private void recViewTue() {
        tuesdayRV.setHasFixedSize(true);
        tuesdayRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        tuesdayRV.setAdapter(timeTableCardAdapter);

    }

    private void recViewMon() {
        mondayRV.setHasFixedSize(true);
        mondayRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mondayRV.setAdapter(timeTableCardAdapter);

    }

    private void createCard() {
        modelClassArrayList = new ArrayList<>();
        modelClassArrayList.add(new TimeTableModelClass(R.drawable.lab_zoom40, "Botany", "Joel E. Rice", "07:00", "08:00"));
        modelClassArrayList.add(new TimeTableModelClass(R.drawable.lab_zoom40, "Botany", "Joel E. Rice", "07:00", "08:00"));
        modelClassArrayList.add(new TimeTableModelClass(R.drawable.lab_zoom40, "Botany", "Joel E. Rice", "07:00", "08:00"));
        modelClassArrayList.add(new TimeTableModelClass(R.drawable.lab_zoom40, "Botany", "Joel E. Rice", "07:00", "08:00"));
        modelClassArrayList.add(new TimeTableModelClass(R.drawable.lab_zoom40, "Botany", "Joel E. Rice", "07:00", "08:00"));
        modelClassArrayList.add(new TimeTableModelClass(R.drawable.lab_zoom40, "Botany", "Joel E. Rice", "07:00", "08:00"));
        modelClassArrayList.add(new TimeTableModelClass(R.drawable.lab_zoom40, "Botany", "Joel E. Rice", "07:00", "08:00"));
        timeTableCardAdapter = new TimeTableCardAdapter(modelClassArrayList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        timeTableView = inflater.inflate(R.layout.fragment_time_table, container, false);
        mondayRV = timeTableView.findViewById(R.id.mondayRV);
        tuesdayRV = timeTableView.findViewById(R.id.tuesdayRV);
        wednesdayRV = timeTableView.findViewById(R.id.wednesdayRV);
        thursdayRV = timeTableView.findViewById(R.id.thursdayRV);
        fridayRV = timeTableView.findViewById(R.id.fridayRV);
        saturdayRV = timeTableView.findViewById(R.id.saturdayRV);
        sundayRV = timeTableView.findViewById(R.id.sundayRV);
        fabButton = timeTableView.findViewById(R.id.createTimeTableButton);
        apiInit();
        getTimeTable();
        createCard();
        buildRecyclerView();
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.containerFragment, new CreateScheduleFragment());
                ft.commit();
            }
        });
        return timeTableView;
    }

    private void getTimeTable() {
        String view = "mobile";
        int classId = 44;
        Call<GetTimetableResponse> getTimetableResponseCall = apiService.GET_TIMETABLE_RESPONSE_CALL(view,classId);
        getTimetableResponseCall.enqueue(new Callback<GetTimetableResponse>() {
            @Override
            public void onResponse(Call<GetTimetableResponse> call, Response<GetTimetableResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                }
                try {
                    GetTimetableResponse getTimetableResponse = response.body();
                    //ArrayList<Occ>
                }catch (Exception e){
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetTimetableResponse> call, Throwable t) {

            }
        });
    }

    private void apiInit() {
        retrofit = ApiClient.getRetrofit();
        apiService = ApiClient.getApiService();
    }
}