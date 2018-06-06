package com.example.dominik.alkotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguj);
        Button button = findViewById(R.id.profilx);
        spinner();
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        profil();
                        //TODO:resjetruj zamienica na logowanie
//                        Intent myIntent = new Intent(v.getContext(), Rejestruj.class);
//                        startActivity(myIntent);
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
            String str = br.readLine();
            TextView textView = findViewById(R.id.wynik_text);
            textView.setText(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
