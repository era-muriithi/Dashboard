package com.example.dashboardlights;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Warning extends Fragment {

    ListView listView;
    String[] lightname = {"Check Engine", "Brake Warning Light", "Battery Charge Warning Light", "Oil Pressure Warning light",
            "Engine Temperature Warning Light", "Steering Wheel Lock", "Trailer Tow Hitch Warning", "Parking Brake Light", "Power Steering Warning Light",
            "Seat Belt Indicator", "Master Warning Light", "Distance Warning", "Catalytic Converter Warning", "Brake Lights Warning", "Automatic Gearbox Warning",
            "All Wheel Drive (AWD/4WD)", "Airbag Indicator", "4 Wheel Drive (4WD) LOCK Indicator Light", "Door Ajar", "Hood/Bonnet Open", "Low Fuel Level", "Adaptive Suspension Dampers",
            "Key Fob Battery Low", "Ignition Switch Warning", "Glow Plug Indicator", "Fuel Filter Warning", "Water Fluid Filter Warning"};
    int[] images = {R.drawable.checklight, R.drawable.brakefluid, R.drawable.battery, R.drawable.oilpressure, R.drawable.temperaturewarning,
            R.drawable.wheellock, R.drawable.tow, R.drawable.parkingbrake, R.drawable.powersteering, R.drawable.seatbelt, R.drawable.master, R.drawable.distance,
            R.drawable.catalytic, R.drawable.brakelight, R.drawable.autogearbox, R.drawable.awd, R.drawable.airbagwarning, R.drawable.awdlock, R.drawable.doorajar, R.drawable.bonnet,
            R.drawable.lowfuel, R.drawable.suspension, R.drawable.keyfob, R.drawable.ignination, R.drawable.glow, R.drawable.fuelfilter, R.drawable.water};

    String details[] = {"Indicator light turns on whenever the engine is turned on to check the bulb. " +
            "If the light stays illuminated, the car’s diagnostic systems have detected a malfunction that needs to be investigated." +
            " A flashing check engine light means that you need to pull over immediately as your vehicle has a serious issue that could cause severe engine damage.",
    "Indicator light turns on when the handbrake is on. If it lit continuously, " +
            "it means that hydraulic pressure has been lost in one side of the brake system or that the fluid level in the master cylinder" +
            " is dangerously low (due to a leak somewhere in the brake system).",
            "Indicator light means that the car’s charging system is short of power or is not charging properly. " +
                    "It normally indicates a problem with the battery itself or the alternator.",
    "Indicator light means loss of oil pressure, meaning lubrication is low or lost completely. Immediately check the oil level and pressure.",
    "Indicator light means the engine temperature has exceeded normal limits. Check coolant level, fan operation, radiator cap, coolant leaks.",
    "Indicator light means your steering wheel is locked and can not be moved. " +
            "To turn off the steering lock, insert the key into the ignition and turn it to at least the " +
            "first position while turning the steering wheel in either direction.",
    "Indicator lights mean that the tow hitch is unlocked or that there’s an issue with the lighting system.",
    "Indicator light means park brake is on.", "Indicator light turns on if there is an issue with the power steering system, and will be disabled until fixed.",
            "Indicator light means that a seat belt has not been secured for a passenger in the vehicle.",

            "Indicator light usually accompanied by another warning light and indicates that one or more warning systems have been detected",

            "Indicator light means that a vehicle in front is too close or is being approached too quickly, or that a stationary obstacle exists in the direction of travel.",

    "Indicator light means the catalytic converter is either overheating or not operating as intended." +
            "" +
            "A catalytic converter uses a chamber called a catalyst to change the harmful compounds from an engine's " +
            "emissions into safe gases, like steam. It works to split up the unsafe molecules in the gases that a car " +
            "produces before they get released into the air.",

    "Indicator light means an exterior brake light bulb is defective. Check the operation of all the exterior brake light bulbs.",

    "Indicator light means there’s a gearbox/transmission malfunction.",

    "Indicator light turns on when there is a malfunction with the 4WD system.",

    "Indicator light turns on when the front airbag is switched off. If this lamp lights up or flashes there is a fault in the airbag or seatbelt system.",

    "Indicator light means that the vehicle’s 4WD Lock mode is activated.",

    "Indicator light turns on when one or more doors of the car are not shut properly.",

    "Indicator light means that the car hood/Bonnet is not closed properly.",

    "Indicator light means that the car is running low on fuel and will soon need a refill.",

    "Indicator light means there is a need to contact an authorised repairer.",

    "Indicator light lets you know when your key fob battery needs to be changed and replaced, so you can continue using the remote.",

    "Indicator light means there’s an issue with the ignition system or the car key. It could be due to a glitch or worn out key.",

    "Indicator light means that the engine’s glow plugs are warming up and the engine should not be started until the light goes out." +
            " If it flashes, an issue has been detected, such as a worn out glow plug.",

    "Indicator light means that the diesel fuel filter is full, and needs to be emptied to avoid engine damage.",

    "Indicator light means water in fuel filter has reached maximum capacity. Drain the water from filter."};
    ListViewAdapter adapter;


    public Warning() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_warning, container, false);
        listView = rootView.findViewById(R.id.lightslist);

        adapter = new ListViewAdapter(getActivity(), lightname, images);
        listView.setAdapter(adapter);
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




