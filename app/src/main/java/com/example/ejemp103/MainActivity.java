package com.example.ejemp103;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView SalidaSensores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SalidaSensores =  findViewById(R.id.Txt_Sensores);
        SensorManager sensorManager =(SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor>ListadoSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor: ListadoSensores){
            log(sensor.getName());
        }
    }

    private void log(String sensores) {
        SalidaSensores.append(sensores +"\n");
    }
}