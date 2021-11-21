package com.example.dashboardlights;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class CheckEngine extends AppCompatActivity {
    TextView lighttitle;
    ImageView imageView;
    ListView lightlist;
    TextView lightdeatils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkengine_activity);


        lighttitle = findViewById(R.id.light_title);
        imageView = findViewById(R.id.lightimage);
        lightlist = findViewById(R.id.lightslist);
        lightdeatils = findViewById(R.id.light_details);

        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image", 0);
        String received_details = intent.getStringExtra("details");
        lighttitle.setText(receivedName);
        imageView.setImageResource(receivedImage);
        lightdeatils.setText(received_details);

        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }

