package com.example.scheduleadmin.AdaptersClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.scheduleadmin.ModelClasses.ScheduledModelClass;
import com.example.scheduleadmin.R;
import com.example.scheduleadmin.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ScheduledAdapter extends RecyclerView.Adapter<ScheduledAdapter.ScheduledViewHolder> {
    private static final String baseUrlForImages = "https://s3.ap-south-1.amazonaws.com/test.files.classroom.digital/";
    ArrayList<ScheduledModelClass> scheduledModelClassArrayList;
    Date date = null;
    Context context;
    String resultStartTime, resultEndTime, formatTwelve;

    public ScheduledAdapter(ArrayList<ScheduledModelClass> scheduledModelClassArrayList) {
        this.scheduledModelClassArrayList = scheduledModelClassArrayList;
    }

    @NonNull
    @Override
    public ScheduledViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View scheduledCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.scheduled_card, parent, false);
        ScheduledViewHolder scheduledViewHolder = new ScheduledViewHolder(scheduledCardView);
        return scheduledViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduledViewHolder holder, int position) {

        ScheduledModelClass currentScheduledModelClass = scheduledModelClassArrayList.get(position);
        SimpleDateFormat twentyfourFormat = new SimpleDateFormat("hh:mm");

        try {
            date = twentyfourFormat.parse(currentScheduledModelClass.getStartTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentScheduledModelClass.getStartTime())) {
            resultStartTime = formatTwelve;
        } else {
            resultStartTime = formatTwelve;
        }

        try {
            date = twentyfourFormat.parse(currentScheduledModelClass.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentScheduledModelClass.getEndTime())) {
            resultEndTime = formatTwelve + "AM";
        } else {
            resultEndTime = formatTwelve + "PM";
        }

        switch (currentScheduledModelClass.getModeImage()) {
            case "Broadcast":
                holder.modeImageView.setImageResource(R.drawable.lab_broadcast);
                break;
            case "Conference":
                holder.modeImageView.setImageResource(R.drawable.lab_conference);
                break;
            case "Offline":
                holder.modeImageView.setImageResource(R.drawable.lab_offline);
                break;
            case "Zoom 40":
                holder.modeImageView.setImageResource(R.drawable.lab_zoom40);
                break;
        }
        holder.startTimeTV.setText(resultStartTime);
        holder.endTimeTV.setText(resultEndTime);
        holder.classAndStreamTV.append(currentScheduledModelClass.getClassName() + " - " + currentScheduledModelClass.getSectionName() + ":" + currentScheduledModelClass.getStreamName());
        holder.subjectTV.setText(currentScheduledModelClass.getSubjectName());
        Glide.with(context).load(baseUrlForImages + currentScheduledModelClass.getTeacherImage()).into(holder.teacherImageView);
        Utils.fetchSvg(context, baseUrlForImages + currentScheduledModelClass.getSubjectImage(), holder.subjectImageView);
    }

    @Override
    public int getItemCount() {
        return scheduledModelClassArrayList.size();
    }

    public class ScheduledViewHolder extends RecyclerView.ViewHolder {
        ImageView modeImageView,subjectImageView,teacherImageView;
        TextView subjectTV, classAndStreamTV, teacherNameTV,startTimeTV,endTimeTV;

        public ScheduledViewHolder(@NonNull View itemView) {
            super(itemView);
            modeImageView = itemView.findViewById(R.id.scheduledModeIV);
            subjectTV = itemView.findViewById(R.id.scheduledSubjectTV);
            classAndStreamTV = itemView.findViewById(R.id.scheduledClassAndStreamTV);
            teacherNameTV = itemView.findViewById(R.id.scheduledTeacherNameTV);
            subjectImageView = itemView.findViewById(R.id.scheduledSubjectIV);
            teacherImageView = itemView.findViewById(R.id.scheduledTeacherIV);
            startTimeTV = itemView.findViewById(R.id.scheduledStartTimeTV);
            endTimeTV = itemView.findViewById(R.id.scheduledEndTime);
        }
    }
}
