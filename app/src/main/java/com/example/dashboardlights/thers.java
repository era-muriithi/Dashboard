package com.example.dashboardlights;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class thers extends Fragment {
    ListView listView;
    String [] lightname = {"Recirculated Cabin Air", "Hill Descent Control", "Cruise Control", "Washer Fluid Reminder", "Rear Window Defrost", "Windshield Defrost"};
    int [] images = {R.drawable.recirculated, R.drawable.hilldescent, R.drawable.cruisecontrol, R.drawable.washer, R.drawable.reardefrost, R.drawable.windshielddefrost};
    ListViewAdapter adapter;


    public thers() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thers, container, false);
        listView = rootView.findViewById(R.id.lightslist);

        adapter = new ListViewAdapter(getActivity(), lightname, images);
        listView.setAdapter(adapter);

        return rootView;
    }
}
