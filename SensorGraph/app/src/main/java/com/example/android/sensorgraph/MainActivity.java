package com.example.android.sensorgraph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // string array of sensors.
        String[] sensors = {"Barometer", "Thermometer"} ;

        // add string of sensors to an adapter so we can use them in a listview.
        ListAdapter sensorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensors );
        // creating a list view
        ListView sensorListView;
        // setting list view to the one in xml for the list view.
        sensorListView = (ListView) findViewById(R.id.main_sensor_list);

        //
        sensorListView.setAdapter(sensorAdapter);

        sensorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i ==0){
                    barometerIntent(view);
                }
                if(i ==1){
                    thermometerIntent(view);
                }
            }
        });
    }
    public void barometerIntent(View view){

        Intent newIntent = new Intent(view.getContext(), BarometerActivity.class);
        startActivityForResult(newIntent,0);

    }
    public void thermometerIntent(View view){

        Intent newIntent = new Intent(view.getContext(), ThermometerActivity.class);
        startActivityForResult(newIntent,0);

    }
}
