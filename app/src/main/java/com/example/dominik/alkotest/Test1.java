package com.example.dominik.alkotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.widget.TextView;

/**
 * Klasa odpowiadająca za obsługę test1
 */

//TODO dodac timer odliczajacy czas pobierania wartosci / dodanie zamkniecia aktywnosci oraz extras na intent z wynikiem

public class Test1 extends AppCompatActivity implements SensorEventListener{

    private float xText, yText, zText, xValue, yValue, zValue, xValueAvg, yValueAvg, zValueAvg;
    private Sensor mySensor;
    private SensorManager SM;
    private float tab[];
    private long i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        // Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * pobieranie oraz sumowanie wartosci z sensorow
     * oraz iteracja sluzaca do tego by wiedziec ile razy zmienila sie wartosc na sensorze
     *
     * @param event zmiana
     */

    @Override
    public void onSensorChanged(SensorEvent event) {
        i++;
        Log.v("Test1", "Ilosc wartosci to: " + Long.toString(i));
        xText = event.values[0];
        xValue = xValue + xText;
        xValueAvg = xValue / i;
        yText = event.values[1];
        yValue = yValue + yText;
        yValueAvg = yValue / i;
        zText = event.values[2];
        zValue = zValue + zText;
        zValueAvg = zValue / i;
    }

}