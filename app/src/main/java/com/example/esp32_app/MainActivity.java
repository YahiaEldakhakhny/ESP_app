package com.example.esp32_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFetchClock, btnSyncClk, btnTimezone;
    TextView tvClk, tvOut;
    String currTimezone;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // no night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //find view by id
        btnFetchClock = findViewById(R.id.btn_fetch_clk);
        btnSyncClk = findViewById(R.id.btn_sync_clk);
        btnTimezone = findViewById(R.id.btn_timezone);
        tvClk = findViewById(R.id.tv_clk);
        tvOut = findViewById(R.id.tv_out);

        // set on click listeners
        btnFetchClock.setOnClickListener(this);
        btnSyncClk.setOnClickListener(this);
        btnTimezone.setOnClickListener(this);

        //shared preference
        SharedPreferences spTimezone = getSharedPreferences("spTimezone", 0);

        currTimezone = spTimezone.getString("currentTimezone", "Cairo");

        //print the current timezone on screen
        tvOut.setText(currTimezone);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_timezone:
                Intent goToTimezones = new Intent(getApplicationContext(), TimeZones.class);
                startActivity(goToTimezones);

            case R.id.btn_fetch_clk:
                fetchClk();

            case R.id.btn_sync_clk:
                syncClk();
        }
    }

    private void syncClk() {
    }

    private void fetchClk() {
    }
}