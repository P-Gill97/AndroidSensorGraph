package com.example.android.sensorgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] sensors = {"Barometer", "Thermometer"} ;
        ListAdapter Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, sensors );

    }
}
