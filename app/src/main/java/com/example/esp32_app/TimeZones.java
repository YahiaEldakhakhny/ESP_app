package com.example.esp32_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class TimeZones extends AppCompatActivity {

    String[] timezonesList = {"Beijing","Cairo","London","Los Angeles","Moscow","New York","Paris",
            "Sydney","Tokyo","Toronto"};
    ListView lvTimeZones;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_zones);

        // no night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        //find view by id
        lvTimeZones = findViewById(R.id.lv_timeZones);
        textView = findViewById(R.id.textView);

        //set array adapter for list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, timezonesList);
        lvTimeZones.setAdapter(adapter);

        //on item clicked
        lvTimeZones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemClicked = adapter.getItem(i);
                //change the current timezone to match the clicked one

                SharedPreferences spTimezone = getSharedPreferences("spTimezone", 0);
                SharedPreferences.Editor pen = spTimezone.edit();
                pen.putString("currentTimezone", itemClicked);
                pen.apply();

                //go back to main activity
                Intent goToMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToMainActivity);
            }
        });


    }
}