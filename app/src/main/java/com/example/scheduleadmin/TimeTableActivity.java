package com.example.scheduleadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.scheduleadmin.Fragments.TimeTableFragment;

public class TimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.containerFragment, new TimeTableFragment());

        ft.commit();
    }
}