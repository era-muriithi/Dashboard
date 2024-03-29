package com.example.dashboardlights;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class CheckEngine extends AppCompatActivity {

    EditText model;
    TextView lighttitle, more_info, share;
    ImageView imageView;
    ListView lightlist;
    TextView lightdeatils;
    Context context;

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
        public void onClick(View view){
            more_info = findViewById(R.id.info);
            model = findViewById(R.id.model);
            String model_name = model.getText().toString();
            Intent intent = getIntent();
            String receivedName = intent.getStringExtra("name");
            String query = receivedName +" "+ model_name;

            if (!TextUtils.isEmpty(model_name)){
                Intent browserIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                browserIntent.putExtra(SearchManager.QUERY, query);
                startActivity(browserIntent);
            } else {
                model.setError("input required");
            }

        }

        public void onClickmaps(View view){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Uri intentUri = Uri.parse("geo:0,0?q=garage");
                Intent mapintent = new Intent(Intent.ACTION_VIEW, intentUri);
                mapintent.setPackage("com.google.android.apps.maps");
                startActivity(mapintent);
            }
        }, 3000);
        }

    public void onClickShare(View view){
        share = findViewById(R.id.share);
        lighttitle = findViewById(R.id.light_title);
        Intent intent = new Intent(Intent.ACTION_SEND);
        String lights_nmae = lighttitle.getText().toString();
        lighttitle.setText(lights_nmae);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, lights_nmae);
        intent.setPackage("com.whatsapp");
        startActivity(intent);
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

