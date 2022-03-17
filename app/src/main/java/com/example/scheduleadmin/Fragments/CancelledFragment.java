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

import com.example.scheduleadmin.AdaptersClasses.CancelledAdapter;
import com.example.scheduleadmin.ApiPackage.ApiClient;
import com.example.scheduleadmin.ApiPackage.ApiService;
import com.example.scheduleadmin.ApiPackage.Cancelled;
import com.example.scheduleadmin.ApiPackage.GetScheduleHomePageResponse;
import com.example.scheduleadmin.ModelClasses.CancelledModelClass;
import com.example.scheduleadmin.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CancelledFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CancelledFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Retrofit retrofit;
    private ApiService apiService;
    private View cancelledView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView cancelledRecyclerView;
    private ArrayList<CancelledModelClass> cancelledModelClassArrayList;

    public CancelledFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CancelledFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CancelledFragment newInstance(String param1, String param2) {
        CancelledFragment fragment = new CancelledFragment();
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

    private void getCancelledClasses() {
        Call<GetScheduleHomePageResponse> getScheduleHomePageResponseCall = apiService.SCHEDULE_HOME_PAGE_RESPONSE_CALL();
        getScheduleHomePageResponseCall.enqueue(new Callback<GetScheduleHomePageResponse>() {
            @Override
            public void onResponse(Call<GetScheduleHomePageResponse> call, Response<GetScheduleHomePageResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                }
                try {
                    GetScheduleHomePageResponse getScheduleHomePageResponse = response.body();
                    List<Cancelled> cancelledList = getScheduleHomePageResponse.getSchedules().getCancelled();
                    LinearLayout noClassCancelledLayout = cancelledView.findViewById(R.id.noClassScheduledLayout);
                    if (cancelledList.size() > 0) {
                        cancelledModelClassArrayList = new ArrayList<>();
                        if (noClassCancelledLayout.getVisibility() == View.VISIBLE) {
                            noClassCancelledLayout.setVisibility(View.GONE);
                        }
                        for (Cancelled c :
                                cancelledList) {
                            cancelledModelClassArrayList.add(new CancelledModelClass(c.getSubject().getName(),
                                    c.getStandards().get(0).getStd(),
                                    c.getStandards().get(0).getSection(),
                                    c.getStandards().get(0).getStream(),
                                    c.getTeacher().getName(),
                                    c.getStartTime().substring(0, c.getStartTime().length() - 3),
                                    c.getEndTime().substring(0, c.getEndTime().length() - 3),
                                    c.getMode(),
                                    c.getSubject().getIcon(),
                                    c.getTeacher().getImage()));
                        }
                        buildRecyclerView();
                    } else {
                        noClassCancelledLayout.setVisibility(View.VISIBLE);
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
        cancelledView = inflater.inflate(R.layout.fragment_cancelled, container, false);
        cancelledRecyclerView = cancelledView.findViewById(R.id.recViewCancelledForCard);
        apiInit();
        getCancelledClasses();
        return cancelledView;
    }

    private void buildRecyclerView() {
        cancelledRecyclerView.setHasFixedSize(true);
        cancelledRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cancelledRecyclerView.setAdapter(new CancelledAdapter(cancelledModelClassArrayList, getContext()));
    }
}