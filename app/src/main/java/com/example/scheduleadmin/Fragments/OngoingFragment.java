package com.example.scheduleadmin.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheduleadmin.AdaptersClasses.OngoingAdapter;
import com.example.scheduleadmin.ApiPackage.ApiClient;
import com.example.scheduleadmin.ApiPackage.ApiService;
import com.example.scheduleadmin.ApiPackage.GetScheduleHomePageResponse;
import com.example.scheduleadmin.ApiPackage.Ongoing;
import com.example.scheduleadmin.ModelClasses.OngoingModelClass;
import com.example.scheduleadmin.R;
import com.example.scheduleadmin.TimeTableActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OngoingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OngoingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button button;
    private View ongoingView;
    private Retrofit retrofit;
    private ApiService apiService;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView ongoingRecyclerView;
    private ArrayList<OngoingModelClass> ongoingModelClassArrayList;
    private LinearLayout noClassOngoingLayout;

    public OngoingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OngingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OngoingFragment newInstance(String param1, String param2) {
        OngoingFragment fragment = new OngoingFragment();
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

    private void getOngoingClasses() {
        Call<GetScheduleHomePageResponse> getScheduleHomePageResponseCall = apiService.SCHEDULE_HOME_PAGE_RESPONSE_CALL();
        getScheduleHomePageResponseCall.enqueue(new Callback<GetScheduleHomePageResponse>() {
            @Override
            public void onResponse(Call<GetScheduleHomePageResponse> call, Response<GetScheduleHomePageResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                }
                try {
                    GetScheduleHomePageResponse getScheduleHomePageResponse = response.body();
                    List<Ongoing> ongoingList = getScheduleHomePageResponse.getSchedules().getOngoing();
                    if (ongoingList.size() > 0) {
                        if (noClassOngoingLayout.getVisibility() == View.VISIBLE) {
                            noClassOngoingLayout.setVisibility(View.GONE);
                        }
                        ongoingModelClassArrayList = new ArrayList<>();
                        for (Ongoing o :
                                ongoingList) {
                            ongoingModelClassArrayList.add(new OngoingModelClass(o.getMode(),
                                    o.getSubject().getIcon(),
                                    o.getSubject().getName(),
                                    o.getStandards().get(0).getStd(),
                                    o.getStandards().get(0).getSection(),
                                    o.getStandards().get(0).getStream(),
                                    o.getTeacher().getImage(),
                                    o.getTeacher().getName(),
                                    o.getStartTime(),
                                    o.getEndTime()));
                        }
                        buildRecyclerView();
                    }else {
                        noClassOngoingLayout.setVisibility(View.VISIBLE);
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
        ongoingView = inflater.inflate(R.layout.fragment_onging, container, false);
        ongoingRecyclerView = ongoingView.findViewById(R.id.recViewForOngoingCard);
        noClassOngoingLayout = ongoingView.findViewById(R.id.noClassOngoingLayout);
        apiInit();
        getOngoingClasses();
        button = ongoingView.findViewById(R.id.createTimeTableButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TimeTableActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return ongoingView;
    }

    private void buildRecyclerView() {

        ongoingRecyclerView.setHasFixedSize(true);
        ongoingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ongoingRecyclerView.setAdapter(new OngoingAdapter(ongoingModelClassArrayList,getContext()));
    }
}