package com.example.dashboardlights;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class Safety extends Fragment {
    ListView listView;
    String [] lightname = {"Transmission Temperature", "Tire Pressure Warning Light", "Traction Control Off", "Traction Control Light", "Service Soon", "Security Alert",
    "Reduced Power", "PowerTrain Fault", "Gas/Fuel Cap", "ESP Fault/Traction Control Malfunction", "Electric Park Brake", "Low Brake Fluid"};
    int [] images = {R.drawable.transmissiontempertaure, R.drawable.lowtirepressure, R.drawable.tractionoff, R.drawable.tractionon, R.drawable.servicesoon, R.drawable.securityalert,
    R.drawable.reducedpower, R.drawable.powertrain, R.drawable.fuelcap, R.drawable.espfault, R.drawable.electricparkbrake, R.drawable.brakefluidlow};
    ListViewAdapter adapter;


    public Safety() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_safety, container, false);
        listView = rootView.findViewById(R.id.lightslist);

        adapter = new ListViewAdapter(getActivity(), lightname, images);
        listView.setAdapter(adapter);

        return rootView;
    }
}