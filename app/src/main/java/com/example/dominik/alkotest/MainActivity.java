package com.example.dominik.alkotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void rejestruj(View view) {

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Rejestruj.class);
        startActivity(myIntent);


    }

    public void loguj(View view) {

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), TestPo.class);
        startActivity(myIntent);

    }

    public void usun(View view) {

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Usun.class);
        startActivity(myIntent);

    }

}