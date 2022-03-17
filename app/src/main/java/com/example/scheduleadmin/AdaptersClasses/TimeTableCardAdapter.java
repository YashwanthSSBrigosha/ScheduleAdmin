package com.example.scheduleadmin.AdaptersClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheduleadmin.ModelClasses.TimeTableModelClass;
import com.example.scheduleadmin.R;

import java.util.ArrayList;

public class TimeTableCardAdapter extends RecyclerView.Adapter<TimeTableCardAdapter.TimeTableViewHolder> {

    ArrayList<TimeTableModelClass> modelClassArrayList;

    public TimeTableCardAdapter(ArrayList<TimeTableModelClass> modelClassArrayList) {
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public TimeTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timetable_card, parent, false);
        TimeTableViewHolder timeTableViewHolder = new TimeTableViewHolder(view);
        return timeTableViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimeTableViewHolder holder, int position) {
        TimeTableModelClass currentClass = modelClassArrayList.get(position);
        switch (currentClass.getMode()) {
            case R.drawable.lab_zoom40:
                holder.backgroundLinearLayout.setBackgroundResource(R.drawable.blue_stroke_background);
                return;
            case R.drawable.lab_offline:
                holder.backgroundLinearLayout.setBackgroundResource(R.drawable.green_stroke_background);
                return;
            case R.drawable.lab_broadcast:
                holder.backgroundLinearLayout.setBackgroundResource(R.drawable.orange_stroke_backround);
                return;
            case R.drawable.lab_conference:
                holder.backgroundLinearLayout.setBackgroundResource(R.drawable.purple_stroke_background);
                return;
        }
        holder.mode.setImageResource(currentClass.getMode());
        holder.subjectName.setText(currentClass.getSubjectName());
        holder.teacherName.setText(currentClass.getTeacherName());
        holder.startTime.setText(currentClass.getStartTime() + " - ");
        holder.endTime.setText(currentClass.getEndTime() + " AM");
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class TimeTableViewHolder extends RecyclerView.ViewHolder {
        TextView subjectName, teacherName, startTime, endTime;
        ImageView mode;
        LinearLayout backgroundLinearLayout;

        public TimeTableViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectName = itemView.findViewById(R.id.subjectTV);
            teacherName = itemView.findViewById(R.id.teacherTV);
            startTime = itemView.findViewById(R.id.startTimeTV);
            endTime = itemView.findViewById(R.id.endTimeTV);
            mode = itemView.findViewById(R.id.modeIV);
            backgroundLinearLayout = itemView.findViewById(R.id.backgroundLayout);
        }
    }
}
