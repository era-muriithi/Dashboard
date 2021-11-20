package com.example.dashboardlights;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Safety extends Fragment {
    ListView listView;
    String[] lightname = {"Transmission Temperature", "Tire Pressure Warning Light", "Traction Control Off", "Traction Control Light", "Service Soon", "Security Alert",
            "Reduced Power", "PowerTrain Fault", "Gas/Fuel Cap", "ESP Fault/Traction Control Malfunction", "Electric Park Brake", "Low Brake Fluid"};
    int[] images = {R.drawable.transmissiontempertaure, R.drawable.lowtirepressure, R.drawable.tractionoff, R.drawable.tractionon, R.drawable.servicesoon, R.drawable.securityalert,
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
        CustomAdapter customAdapter = new CustomAdapter();

        adapter = new ListViewAdapter(getActivity(), lightname, images);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getContext(), CheckEngine.class);
                intent.putExtra("name", lightname[i]);
                intent.putExtra("image", images[i]);
                startActivity(intent);
            }
        });
        return rootView;
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.custom_item, null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.lightname);
            ImageView image = view1.findViewById(R.id.img);

            name.setText(lightname[i]);
            image.setImageResource(images[i]);
            return view1;
        }

    }
}
