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
    String [] lightname = {"Check Engine", "Brake Fluid", "Airbag"};
    int [] images = {R.drawable.checklight, R.drawable.brakefluid, R.drawable.airbagwarning};
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

        };

    }