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
    String [] lightname = {"Check Engine", "Brake Fluid", "Airbag"};
    int [] images = {R.drawable.checklight, R.drawable.brakefluid, R.drawable.airbagwarning};
    Context context;
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