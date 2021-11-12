package com.example.dashboardlights;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public MyAdapter(Context c, FragmentManager fm, int totalTabs){
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            Warning warningLightsFragment = new Warning();
            return warningLightsFragment;

            case 1:
                Safety safetyFragment = new Safety();
                return safetyFragment;

            case 2:
                Lights lightsFragments = new Lights();
                return lightsFragments;
            case  3:
                thers thersFragment = new thers();
                return thersFragment;
            default:
                return null;
        }
    }

    public int getCount() {
        return totalTabs;
    }
}
