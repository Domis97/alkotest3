package com.example.dominik.alkotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Loguj extends AppCompatActivity {

    String wybor;
    String wynik1;
    String wynik2;
    private long wynik1L;
    private long wynik2L;
    private long wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguj);


        Bundle temp = getIntent().getExtras();//przekazani wynik2
        if (temp != null) {
            wynik2 = (String) temp.get("wartosc");
            wynik2L = Long.valueOf(wynik2);
        }

        Button button = findViewById(R.id.porownaj);
        spinner();
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        profil();
                        wynik1L = Long.valueOf(wynik1);
                        wynik = wynik2L - wynik1L;
                        TextView textView = findViewById(R.id.wynik_koncowy);
                        if (wynik > 400) {
                            textView.setText(String.valueOf("Jak Adas na pikniku"));
                        } else if (wynik > 250) {
                            textView.setText(String.valueOf("Jak Domis po 100ml"));
                        } else {
                            textView.setText(String.valueOf("Trzezwy jak KaKa"));
                        }
                    }
                }
        );

    }

    public void spinner() {

        List<String> spinnerArray = new ArrayList<>();
        for (String s : fileList()) {
            spinnerArray.add(s);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = findViewById(R.id.profile);
        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                wybor = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void profil() {


        try {
            FileInputStream fileInputStream = openFileInput(wybor);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            wynik1 = br.readLine();
            TextView textView = findViewById(R.id.wynik_text);
            textView.setText("Wynik 1 to: " + wynik1);
            br.close();
            TextView textView1 = findViewById(R.id.wynik_Po);
            textView1.setText("Wynik 2 to: " + wynik2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
