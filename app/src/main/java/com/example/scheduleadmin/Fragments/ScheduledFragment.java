package com.example.scheduleadmin.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheduleadmin.AdaptersClasses.ScheduledAdapter;
import com.example.scheduleadmin.ApiPackage.ApiClient;
import com.example.scheduleadmin.ApiPackage.ApiService;
import com.example.scheduleadmin.ApiPackage.GetScheduleHomePageResponse;
import com.example.scheduleadmin.ApiPackage.Scheduled;
import com.example.scheduleadmin.ModelClasses.ScheduledModelClass;
import com.example.scheduleadmin.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduledFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduledFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View scheduledView;
    private Retrofit retrofit;
    private ApiService apiService;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<ScheduledModelClass> scheduledClassesArrayList;
    private RecyclerView scheduledRecyclerView;
    LinearLayout noClassScheduledLayout;

    public ScheduledFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduledFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduledFragment newInstance(String param1, String param2) {
        ScheduledFragment fragment = new ScheduledFragment();
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

    private void apiInit() {
        retrofit = ApiClient.getRetrofit();
        apiService = ApiClient.getApiService();
    }

    private void getScheduledClasses() {
        Call<GetScheduleHomePageResponse> getScheduleHomePageResponseCall = apiService.SCHEDULE_HOME_PAGE_RESPONSE_CALL();
        getScheduleHomePageResponseCall.enqueue(new Callback<GetScheduleHomePageResponse>() {
            @Override
            public void onResponse(Call<GetScheduleHomePageResponse> call, Response<GetScheduleHomePageResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                }
                try {
                    GetScheduleHomePageResponse getScheduleHomePageResponse = response.body();
                    List<Scheduled> scheduledList = getScheduleHomePageResponse.getSchedules().getScheduled();
                    if (scheduledList.size()>0){
                        if (noClassScheduledLayout.getVisibility() == View.VISIBLE){
                            noClassScheduledLayout.setVisibility(View.GONE);
                        }
                        scheduledClassesArrayList = new ArrayList<>();
                        for (Scheduled s:
                             scheduledList) {
                            scheduledClassesArrayList.add(new ScheduledModelClass(s.getMode(),
                                    s.getSubject().getIcon(),
                                    s.getSubject().getName(),
                                    s.getStandards().get(0).getStd(),
                                    s.getStandards().get(0).getSection(),
                                    s.getStandards().get(0).getStream(),
                                    s.getTeacher().getImage(),
                                    s.getTeacher().getName(),
                                    s.getStartTime(),
                                    s.getEndTime()));
                        }
                        buildRecyclerView();
                    }else {
                        noClassScheduledLayout.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetScheduleHomePageResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        scheduledView = inflater.inflate(R.layout.fragment_scheduled, container, false);
        scheduledRecyclerView = scheduledView.findViewById(R.id.recViewForScheduledCard);
        noClassScheduledLayout = scheduledView.findViewById(R.id.noClassScheduledLayout);
        apiInit();
        getScheduledClasses();
        return scheduledView;
    }

    private void buildRecyclerView() {
        scheduledRecyclerView.setHasFixedSize(true);
        scheduledRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        scheduledRecyclerView.setAdapter(new ScheduledAdapter(scheduledClassesArrayList));
    }
}