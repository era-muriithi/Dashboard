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
    String[] details = {"Indicator light means the engine temperature has exceeded normal limits. " +
            "Check coolant level, fan operation, radiator cap, coolant leaks.", "Indicator light means the pressure is low in one of your tires.",
    "Indicator light turns on when the vehicle TCS (traction control system) has been deactivated. Traction control is a system that stops the wheels of a " +
            "vehicle from spinning when excess power is applied. If the rear does begin to skid on a greasy surface, or with too much throttle, " +
            "traction control takes over. Traction control provides much-needed safety if road conditions cause any of a car's wheels to slip.",
    "Indicator light turns on when the vehicle TCS (traction control system) has been activated. Traction control is a system that stops the wheels " +
            "of a vehicle from spinning when excess power is applied. If the rear does begin to skid on a greasy surface, or with too much throttle " +
            "traction control takes over. Traction control provides much-needed safety if road conditions cause any of a car's wheels to slip.",
    "Indicator light turns on when there is a fault condition in an area of the vehicle chassis systems such as—the anti-lock (ABS) brake system, " +
            "the traction control (TCS) system, the electronic suspension system, or the brake hydraulic system.",
    "Indicator light will turn on momentarily if the ignition switch is locked and will need the proper transponder-equipped key to restart. " +
            "If the light is visible when the vehicle is on, then it typically indicates a malfunction in the security system.",
    "The reduced engine power light is a generic warning that can cover many faults, so if it’s the only warning light that’s on, diagnostic code readers are usually required to locate the fault. Faults related to reduced engine power include:\n" +
            "\n" +
            "Engine / turbo boost control\n" +
            "Engine wiring issues\n" +
            "Engine component faults\n" +
            "Faulty engine sensors\n" +
            "Faulty oxygen sensor\n" +
            "Emissions system / engine misfire\n" +
            "Transmission faults\n" +
            "Transmission wiring issues\n" +
            "Electronic throttle control (ETC) system / defective throttle position sensor",
    "Indicator light turns on when a powertrain or AWD fault has been detected. Contact your mechanic as soon as possible.",
    "Indicator light turns on if the gas/fuel cap is not properly tightened.",
    "Indicator light means that there is a problem with the vehicle’s traction control. What does traction control do?\n" +
            "Traction control is an active safety feature that helps to keep traction between the tires and the road in slippery " +
            "or dangerous conditions. The safety feature maintains a car's traction by limiting how much the wheels can spin, making " +
            "it easier to stay connected to the surface you're driving on",
    "Indicator light turns on when the electric parking brake has a malfunction",
    "Indicator light means that the brake fluid level is low."};
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
                intent.putExtra("details", details[i]);
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
