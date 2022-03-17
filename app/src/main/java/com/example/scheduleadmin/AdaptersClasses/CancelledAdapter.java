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
import com.example.scheduleadmin.ModelClasses.CancelledModelClass;
import com.example.scheduleadmin.R;
import com.example.scheduleadmin.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CancelledAdapter extends RecyclerView.Adapter<CancelledAdapter.CancelledViewHolder> {

    ArrayList<CancelledModelClass> cancelledModelClassArrayList;
    Date date = null;
    Context context;
    String resultStartTime, resultEndTime, formatTwelve;
    private static final String baseUrlForImages = "https://s3.ap-south-1.amazonaws.com/test.files.classroom.digital/";

    public CancelledAdapter(ArrayList<CancelledModelClass> cancelledModelClassArrayList, Context context) {
        this.cancelledModelClassArrayList = cancelledModelClassArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CancelledAdapter.CancelledViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cancelledCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cancelled_card, parent, false);
        CancelledViewHolder cancelledViewHolder = new CancelledViewHolder(cancelledCardView);
        return cancelledViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CancelledAdapter.CancelledViewHolder holder, int position) {
        CancelledModelClass currentCancelledModelClass = cancelledModelClassArrayList.get(position);
        SimpleDateFormat twentyfourFormat = new SimpleDateFormat("hh:mm");

        try {
            date = twentyfourFormat.parse(currentCancelledModelClass.getStartTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentCancelledModelClass.getStartTime())) {
            resultStartTime = formatTwelve;
        } else {
            resultStartTime = formatTwelve;
        }

        try {
            date = twentyfourFormat.parse(currentCancelledModelClass.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatTwelve = twentyfourFormat.format(date);
        if (formatTwelve.equals(currentCancelledModelClass.getEndTime())) {
            resultEndTime = formatTwelve + "AM";
        } else {
            resultEndTime = formatTwelve + "PM";
        }

        switch (currentCancelledModelClass.getModeImage()) {
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
        Utils.fetchSvg(context, baseUrlForImages + currentCancelledModelClass.getSubjectImage(), holder.subjectImage);
        holder.subjectTV.setText(currentCancelledModelClass.getSubjectName());
        holder.classAndStreamTV.append(currentCancelledModelClass.getClassName()+"-"+currentCancelledModelClass.getSectionName()+":"+currentCancelledModelClass.getStreamName());
        Glide.with(context).load(baseUrlForImages + currentCancelledModelClass.getTeacherImage()).into(holder.teacherImage);
        holder.teacherNameTV.setText(currentCancelledModelClass.getTeacherName());
        holder.startTimeTV.setText(resultStartTime);
        holder.endTimeTV.setText(resultEndTime);

    }

    @Override
    public int getItemCount() {
        return cancelledModelClassArrayList.size();

    }

    public class CancelledViewHolder extends RecyclerView.ViewHolder {
        ImageView modeImageView, teacherImage, subjectImage;
        TextView subjectTV, classAndStreamTV, teacherNameTV, startTimeTV, endTimeTV;

        public CancelledViewHolder(@NonNull View itemView) {
            super(itemView);
            modeImageView = itemView.findViewById(R.id.cancelledModeIV);
            subjectTV = itemView.findViewById(R.id.cancelledSubTV);
            classAndStreamTV = itemView.findViewById(R.id.cancelledClassAndStreamTV);
            teacherNameTV = itemView.findViewById(R.id.cancelledTeacherNameTV);
            teacherImage = itemView.findViewById(R.id.cancelledTeacherIV);
            subjectImage = itemView.findViewById(R.id.scheduledSubjectIV);
            startTimeTV = itemView.findViewById(R.id.cancelledStartTimeTV);
            endTimeTV = itemView.findViewById(R.id.cancelledEndTimeTV);
        }
    }
}
