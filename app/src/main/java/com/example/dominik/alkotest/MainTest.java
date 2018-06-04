package com.example.dominik.alkotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
    }

    public void test1(android.view.View v){

        android.content.Intent myIntent = new android.content.Intent(v.getContext(), Test1.class);
        startActivity(myIntent);
    }

    public void test2(View view){

                        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Test2.class);
                        startActivity(myIntent);

    }

    public void zapisz(View view){
        android.widget.Button Act1button = (Button)findViewById(R.id.zapisz);

    }
}
