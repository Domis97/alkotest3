package com.example.dominik.alkotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rejestruj extends AppCompatActivity {

    String Imie;

    public String getImie() {
        return Imie;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestruj);
    }

    public void test1(View view){

                        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Test1.class);
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

