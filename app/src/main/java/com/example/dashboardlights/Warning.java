package com.example.dashboardlights;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Warning extends Fragment {
    ListView listView;
    String [] lightname = {"Check Engine", "Brake Warning Light", "Battery Charge Warning Light", "Oil Pressure Warning light",
            "Engine Temperature Warning Light", "Steering Wheel Lock", "Trailer Tow Hitch Warning", "Parking Brake Light", "Power Steering Warning Light",
    "Seat Belt Indicator", "Master Warning Light", "Distance Warning", "Catalytic Converter Warning", "Brake Lights Warning", "Automatic Gearbox Warning",
    "All Wheel Drive (AWD/4WD)", "Airbag Indicator", "4 Wheel Drive (4WD) LOCK Indicator Light", "Door Ajar", "Hood/Bonnet Open", "Low Fuel Level", "Adaptive Suspension Dampers",
    "Key Fob Battery Low", "Ignition Switch Warning", "Glow Plug Indicator", "Fuel Filter Warning", "Water Fluid Filter Warning"};
    int [] images = {R.drawable.checklight, R.drawable.brakefluid, R.drawable.battery, R.drawable.oilpressure, R.drawable.temperaturewarning,
    R.drawable.wheellock, R.drawable.tow, R.drawable.parkingbrake, R.drawable.powersteering, R.drawable.seatbelt, R.drawable.master, R.drawable.distance,
    R.drawable.catalytic, R.drawable.brakelight, R.drawable.autogearbox, R.drawable.awd, R.drawable.airbagwarning, R.drawable.awdlock, R.drawable.doorajar, R.drawable.bonnet,
    R.drawable.lowfuel, R.drawable.suspension, R.drawable.keyfob, R.drawable.ignination, R.drawable.glow, R.drawable.fuelfilter, R.drawable.water};
    Context context;
    ListViewAdapter adapter;


    public Warning() {
    }


        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_warning, container, false);
        listView = rootView.findViewById(R.id.lightslist);

            adapter = new ListViewAdapter(getActivity(), lightname, images);
            listView.setAdapter(adapter);

            return rootView;

        }

    }