package com.example.scheduleadmin.AdaptersClasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.scheduleadmin.Fragments.CancelledFragment;
import com.example.scheduleadmin.Fragments.CompletedFragment;
import com.example.scheduleadmin.Fragments.OngoingFragment;
import com.example.scheduleadmin.Fragments.ScheduledFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CompletedFragment();
            case 1:
                return new OngoingFragment();
            case 2:
                return new ScheduledFragment();
            case 3:
                return new CancelledFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
