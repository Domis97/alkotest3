package com.example.dominik.alkotest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;

/**
 * Klasa odpowiadająca za obsługę ekranu rejestracji z dwoma testami oraz zapisem do pliku
 * Klasia posiada następujące zmienne publiczne
 */


public class Rejestruj extends AppCompatActivity {
    protected String imie;
    private Test2Gra test2Gra;
    private String value;

    /**
     * getter zwracajacy imie
     *
     * @return imie
     */

    public String getImie() {
        return imie;
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
                Intent myIntent = new Intent(v.getContext(), HomeActivity.class);
                startActivity(myIntent);
            }
        });

    }

    /**
     * przejscie do test1
     *
     * @param view widok
     */

    public void test1(View view) {

        Intent myIntent = new Intent(view.getContext(), Test1.class);
        startActivity(myIntent);
    }

    /**
     * przejscie do test2 oraz request na wynik tego testu
     * @param view widok
     */
    public void test2(View view) {

        Intent myIntent = new Intent(view.getContext(), Test2.class);
        int requestCode = 1;
        startActivityForResult(myIntent, requestCode);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        value = data.getStringExtra("someValue");
    }

    /**
     * Zapis wartosci z testu 2 do pliku pod nazwa z Stringa imie
     */

    public void zapisz() {

        EditText editText = findViewById(R.id.imie);

        String fileContents = value;
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput((editText.getText().toString()), Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            Log.v("Test2", "Do pliku " + value);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test2", "Nie dziala zapis");
        }


    }
}