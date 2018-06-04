package com.example.dominik.alkotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loguj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguj);
    }

    public void profil(View view){
    android.widget.Button Act1button = (android.widget.Button)findViewById(R.id.profilx);


        Act1button.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        android.content.Intent myIntent = new android.content.Intent(v.getContext(), MainTest.class);
                        startActivity(myIntent);
                    }
                }
        );
    }
}
