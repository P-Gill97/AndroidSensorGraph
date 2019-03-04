package com.example.android.sensorgraph;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class BarometerActivity extends AppCompatActivity {

    private SensorManager manager;
    private Sensor barometerSensor;
    private TextView tv;
    private LineGraphSeries<DataPoint>  points;
    private SensorEventListener eventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            tv.setText(String.format("%.2f Millibar",values[0]));
            // add changes to graphview here

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barometer);
        tv = findViewById(R.id.barometer_text_display);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        barometerSensor = manager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        GraphView graph = (GraphView) findViewById(R.id.barometer_graph);
        graph.addSeries(points);
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(10);
        viewport.setScrollable(true);
    }
    // add data to graph
    private void addData(){
        // resume here
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(eventListener,barometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(eventListener);
    }
}
