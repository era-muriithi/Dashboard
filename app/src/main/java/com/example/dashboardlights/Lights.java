package com.example.dashboardlights;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Lights extends Fragment {
    ListView listView;
    String [] lightname = {"Low Bean Indicator", "High Beam Indicator", "Exterior Light Fault", "Headlight Range Control", "Front Fog Lights", "Adaptive Light System", "Side Light Indicator",
    "Rear Fog Lights Switched On", "Rain and Light Sensor"};
    int [] images = {R.drawable.lowbeam, R.drawable.highbeam, R.drawable.lampout, R.drawable.range, R.drawable.fog, R.drawable.adaptive, R.drawable.sidelights, R.drawable.rearfog,
    R.drawable.rain};
    ListViewAdapter adapter;


    public Lights() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lights, container, false);
        listView = rootView.findViewById(R.id.lightslist);

        adapter = new ListViewAdapter(getActivity(), lightname, images);
        listView.setAdapter(adapter);

        return rootView;
    }
}