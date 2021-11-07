package com.example.dashboardlights;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    String[] lightname;
    int[] images;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] lightname, int[] images) {
        this.context = context;
        this.lightname = lightname;
        this.images = images;
    }

    public  int getCount(){
        return lightname.length;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView lightnameTxt;
        ImageView img;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.custom_item, parent, false);

        lightnameTxt = itemView.findViewById(R.id.lightname);
        img = itemView.findViewById(R.id.img);

        lightnameTxt.setText(lightname[position]);
        img.setImageResource(images[position]);

        return itemView;
    }
}
