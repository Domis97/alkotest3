package com.example.dominik.alkotest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

public class Rejestruj extends AppCompatActivity {

    String Imie;
    private Test2Gra test2Gra;
    String result;
    String value;

    public void setResult(String result) {
        this.result = result;
    }

    public String getImie() {
        return Imie;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestruj);
        Button save = findViewById(R.id.zapisz);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zapisz();
            }
        });

    }

    public void test1(View view) {

        Intent myIntent = new Intent(view.getContext(), Test1.class);
        startActivity(myIntent);
    }

    public void test2(View view) {

        Intent myIntent = new Intent(view.getContext(), Test2.class);
        int requestCode = 1;
        startActivityForResult(myIntent, requestCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        value = data.getStringExtra("someValue");
    }

    public void zapisz() {

        EditText editText = findViewById(R.id.imie);
        String text = editText.getText().toString();

        String filename = text;
        String fileContents = value;
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            Log.v("Test2", "Do pliku " + value);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test2", "Nie dziala zapis");
        }


    }
}