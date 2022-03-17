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
import com.example.scheduleadmin.ModelClasses.CompletedModelClass;
import com.example.scheduleadmin.R;
import com.example.scheduleadmin.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CompletedAdapter extends RecyclerView.Adapter<CompletedAdapter.CompletedViewHolder> {

    private static final String baseUrlForImages = "https://s3.ap-south-1.amazonaws.com/test.files.classroom.digital/";
    ArrayList<CompletedModelClass> completedModelClassArrayList;
    Date date = null;
    Context context;
    String resultStartTime, resultEndTime, formatTwelve;

    public CompletedAdapter(ArrayList<CompletedModelClass> completedModelClassArrayList, Context context) {
        this.completedModelClassArrayList = completedModelClassArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CompletedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View completedCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.completed_card, parent, false);
        CompletedViewHolder completedViewHolder = new CompletedViewHolder(completedCardView);
        return completedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CompletedViewHolder holder, int position) {

        CompletedModelClass currentCompletedModelClass = completedModelClassArrayList.get(position);
        SimpleDateFormat twentyfourFormat = new SimpleDateFormat("hh:mm");

        try {
            date = twentyfourFormat.parse(currentCompletedModelClass.getStartTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentCompletedModelClass.getStartTime())) {
            resultStartTime = formatTwelve;
        } else {
            resultStartTime = formatTwelve;
        }

        try {
            date = twentyfourFormat.parse(currentCompletedModelClass.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentCompletedModelClass.getEndTime())) {
            resultEndTime = formatTwelve + "AM";
        } else {
            resultEndTime = formatTwelve + "PM";
        }

        switch (currentCompletedModelClass.getModeImageView()) {
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
        Glide.with(context).load(baseUrlForImages + currentCompletedModelClass.getTeacherImage()).into(holder.teacherImageView);
        Utils.fetchSvg(context, baseUrlForImages + currentCompletedModelClass.getSubjectImageView(), holder.subjectImageView);
        holder.startTimeTV.setText(resultStartTime);
        holder.endTimeTV.setText(resultEndTime);
        holder.classAndStreamTV.append(currentCompletedModelClass.getClassName() + " - " + currentCompletedModelClass.getSectionName() + ":" + currentCompletedModelClass.getStreamName());
        holder.subjectTV.setText(currentCompletedModelClass.getSubjectName());


    }

    @Override
    public int getItemCount() {
        return completedModelClassArrayList.size();
    }

    public class CompletedViewHolder extends RecyclerView.ViewHolder {
        ImageView modeImageView, subjectImageView, teacherImageView;
        TextView subjectTV, classAndStreamTV, teacherNameTV, startTimeTV, endTimeTV;

        public CompletedViewHolder(@NonNull View itemView) {
            super(itemView);

            modeImageView = itemView.findViewById(R.id.modeCompletedIV);
            subjectImageView = itemView.findViewById(R.id.completedSubjectIV);
            subjectTV = itemView.findViewById(R.id.subjectCompletedTV);
            classAndStreamTV = itemView.findViewById(R.id.classAndStreamCompetedTV);
            teacherNameTV = itemView.findViewById(R.id.completedTeacherTV);
            teacherImageView = itemView.findViewById(R.id.completedTeacherIV);
            startTimeTV = itemView.findViewById(R.id.completedStartTimeTV);
            endTimeTV = itemView.findViewById(R.id.completedEndTimeTV);
        }
    }
}
