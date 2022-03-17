package com.example.scheduleadmin.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.dpro.widgets.OnWeekdaysChangeListener;
import com.dpro.widgets.WeekdaysPicker;
import com.example.scheduleadmin.R;
import com.example.scheduleadmin.TimePickerBottomsheetDialog;

import java.util.List;


public class CreateScheduleFragment extends Fragment {
    AutoCompleteTextView startDate, startTime, endTime;
    Button zoomButton, conferenceButton, broadcastButton, offlineButton;
    private View createScheduleView;

    public CreateScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        createScheduleView = inflater.inflate(R.layout.fragment_create_schedule, container, false);
        initWidgets();
        WeekdaysPicker widget = (WeekdaysPicker) createScheduleView.findViewById(R.id.weekdays);
        widget.setOnWeekdaysChangeListener(new OnWeekdaysChangeListener() {
            @Override
            public void onChange(View view, int clickedDayOfWeek, List<Integer> selectedDays) {
                // Do Something
            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerBottomsheetDialog timePickerBottomsheet = new TimePickerBottomsheetDialog();
                timePickerBottomsheet.show(getParentFragmentManager(), "timePickerBottomSheet");
                Toast.makeText(getContext(), "endtime clicked", Toast.LENGTH_SHORT).show();
            }
        });

        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerBottomsheetDialog timePickerBottomsheet = new TimePickerBottomsheetDialog();
                timePickerBottomsheet.show(getParentFragmentManager(), "timePickerBottomSheet");
                Toast.makeText(getContext(), "starttime clicked", Toast.LENGTH_SHORT).show();
            }
        });
        zoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomButton.setBackgroundResource(R.drawable.zoom_selected);
                zoomButton.setTextColor(Color.WHITE);
                conferenceButton.setBackgroundResource(R.drawable.conference_default);
                conferenceButton.setTextColor(getResources().getColor(R.color.conference_selected));
                broadcastButton.setBackgroundResource(R.drawable.broadcast_default);
                broadcastButton.setTextColor(getResources().getColor(R.color.broadcast_selected));
                offlineButton.setBackgroundResource(R.drawable.offline_default);
                offlineButton.setTextColor(getResources().getColor(R.color.offline_selected));
            }
        });

        conferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conferenceButton.setBackgroundResource(R.drawable.conference_selected);
                conferenceButton.setTextColor(Color.WHITE);
                zoomButton.setBackgroundResource(R.drawable.zoom_default);
                zoomButton.setTextColor(getResources().getColor(R.color.zoom_selected));
                broadcastButton.setBackgroundResource(R.drawable.broadcast_default);
                broadcastButton.setTextColor(getResources().getColor(R.color.broadcast_selected));
                offlineButton.setBackgroundResource(R.drawable.offline_default);
                offlineButton.setTextColor(getResources().getColor(R.color.offline_selected));
            }
        });

        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                broadcastButton.setBackgroundResource(R.drawable.broadcast_selected);
                broadcastButton.setTextColor(Color.WHITE);
                conferenceButton.setBackgroundResource(R.drawable.conference_default);
                conferenceButton.setTextColor(getResources().getColor(R.color.conference_selected));
                zoomButton.setBackgroundResource(R.drawable.zoom_default);
                zoomButton.setTextColor(getResources().getColor(R.color.zoom_selected));
                offlineButton.setBackgroundResource(R.drawable.offline_default);
                offlineButton.setTextColor(getResources().getColor(R.color.offline_selected));
            }
        });

        offlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offlineButton.setBackgroundResource(R.drawable.offline_selected);
                offlineButton.setTextColor(Color.WHITE);
                zoomButton.setBackgroundResource(R.drawable.zoom_default);
                zoomButton.setTextColor(getResources().getColor(R.color.zoom_selected));
                conferenceButton.setBackgroundResource(R.drawable.conference_default);
                conferenceButton.setTextColor(getResources().getColor(R.color.conference_selected));
                broadcastButton.setBackgroundResource(R.drawable.broadcast_default);
                broadcastButton.setTextColor(getResources().getColor(R.color.broadcast_selected));
            }
        });

        return createScheduleView;
    }

    private void initWidgets() {
        startDate = createScheduleView.findViewById(R.id.startDate);
        startTime = createScheduleView.findViewById(R.id.startTimeACTV);
        endTime = createScheduleView.findViewById(R.id.endTimeACTV);
        zoomButton = createScheduleView.findViewById(R.id.zoomButton);
        conferenceButton = createScheduleView.findViewById(R.id.conferenceButton);
        broadcastButton = createScheduleView.findViewById(R.id.broadcastButton);
        offlineButton = createScheduleView.findViewById(R.id.offlineButton);

    }
}