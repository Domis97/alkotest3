package com.example.dominik.alkotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestPo extends AppCompatActivity {

    String wartosc = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_po);
    }

    public void test1(View view) {

        Intent myIntent = new Intent(view.getContext(), Test1.class);
        startActivity(myIntent);
    }

    public void test2(View view) {

        Intent myIntent = new Intent(view.getContext(), Test2.class);
        int requestCode = 2;
        startActivityForResult(myIntent, requestCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        wartosc = data.getStringExtra("someValue");
    }

    public void logowanie(View view) {
        long temp = Long.valueOf(wartosc);//zeby nie wchodzil do buttona
        if (temp != 0) {
            Intent myIntent = new Intent(view.getContext(), Loguj.class);
            myIntent.putExtra("wartosc", wartosc);
            startActivity(myIntent);
        }
    }
}
