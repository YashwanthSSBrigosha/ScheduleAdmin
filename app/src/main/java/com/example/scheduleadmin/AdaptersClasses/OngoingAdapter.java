package com.example.scheduleadmin.AdaptersClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.scheduleadmin.ModelClasses.OngoingModelClass;
import com.example.scheduleadmin.R;
import com.example.scheduleadmin.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.OngoingViewHolder> {

    private static final String baseUrlForImages = "https://s3.ap-south-1.amazonaws.com/test.files.classroom.digital/";
    ArrayList<OngoingModelClass> ongoingModelClassArrayList;
    Date date = null;
    Context context;
    String resultStartTime, resultEndTime, formatTwelve, resultStartTimeProgress;

    public OngoingAdapter(ArrayList<OngoingModelClass> ongoingModelClassArrayList, Context context) {
        this.ongoingModelClassArrayList = ongoingModelClassArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public OngoingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ongoingCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoing_card, parent, false);
        OngoingViewHolder ongoingViewHolder = new OngoingViewHolder(ongoingCardView);
        return ongoingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingViewHolder holder, int position) {

        OngoingModelClass currentOngoingModelClass = ongoingModelClassArrayList.get(position);

        SimpleDateFormat twentyfourFormat = new SimpleDateFormat("hh:mm");

        try {
            date = twentyfourFormat.parse(currentOngoingModelClass.getStartTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentOngoingModelClass.getStartTime())) {
            resultStartTime = formatTwelve;
        } else {
            resultStartTime = formatTwelve;
        }

        try {
            date = twentyfourFormat.parse(currentOngoingModelClass.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentOngoingModelClass.getEndTime())) {
            resultEndTime = formatTwelve + "AM";
            resultStartTimeProgress = formatTwelve + "AM";
        } else {
            resultEndTime = formatTwelve + "PM";
            resultStartTimeProgress = formatTwelve + "PM";
        }

        switch (currentOngoingModelClass.getModeImage()) {
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
        Glide.with(context).load(baseUrlForImages + currentOngoingModelClass.getTeacherImage()).into(holder.teacherImageView);
        Utils.fetchSvg(context, baseUrlForImages + currentOngoingModelClass.getSubjectImage(), holder.subjectImageView);
        holder.startTimeTV.setText(currentOngoingModelClass.getStartTime());
        holder.endTimeTV.setText(currentOngoingModelClass.getEndTime());
        holder.progressBArStartTime.setText(resultStartTimeProgress);
        holder.progressBarEndTime.setText(resultEndTime);
    }

    @Override
    public int getItemCount() {
        return ongoingModelClassArrayList.size();
    }

    public class OngoingViewHolder extends RecyclerView.ViewHolder {
        ImageView modeImageView, subjectImageView, teacherImageView;
        TextView subjectTV, classAndStreamTV, teacherNameTV, startTimeTV, endTimeTV, progressBArStartTime, progressBarEndTime;
        ProgressBar progressBar;

        public OngoingViewHolder(@NonNull View itemView) {
            super(itemView);

            modeImageView = itemView.findViewById(R.id.ongoingModeIV);
            subjectTV = itemView.findViewById(R.id.ongoingSubTV);
            classAndStreamTV = itemView.findViewById(R.id.ongoingClassAndStreamTV);
            teacherNameTV = itemView.findViewById(R.id.ongoingTeacherNameTV);
            subjectImageView = itemView.findViewById(R.id.ongoingSubIV);
            teacherImageView = itemView.findViewById(R.id.ongoingTeacherIV);
            startTimeTV = itemView.findViewById(R.id.startTimeTV);
            endTimeTV = itemView.findViewById(R.id.endTimeTV);
            progressBArStartTime = itemView.findViewById(R.id.progressStartTimeTV);
            progressBarEndTime = itemView.findViewById(R.id.progressEndTimeTV);
            progressBar = itemView.findViewById(R.id.ongoingProgressBar);

        }
    }
}
