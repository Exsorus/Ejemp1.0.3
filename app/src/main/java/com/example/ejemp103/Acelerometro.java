package com.example.ejemp103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Acelerometro extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor acelerometro;
    TextView X,Y, Z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        X = findViewById(R.id.ejeX);
        Z = findViewById(R.id.ejeZ);
        Y = findViewById(R.id.ejeY);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    protected  void onResume(){
        super.onResume();
        sensorManager.registerListener(this,acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected  void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float ejeX = event.values[0];
        X.setText(String.valueOf(ejeX));
        float ejeY = event.values[1];
        Y.setText(String.valueOf(ejeY));
        float ejeZ = event.values[2];
        Z.setText(String.valueOf(ejeZ));


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}