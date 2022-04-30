package com.example.esp32_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TimeZones extends AppCompatActivity {

    String[] timezonesList = {"Beijing","Cairo","London","Los Angeles","Moscow","New York","Paris",
            "Sydney","Tokyo","Toronto"};
    ListView lvTimeZones;
    TextView textView;
    MainActivity objTimezone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_zones);


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
                objTimezone.currTimezone = timezonesList[i];
                Intent goToMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToMainActivity);
            }
        });


    }
}