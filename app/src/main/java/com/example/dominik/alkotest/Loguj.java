package com.example.dominik.alkotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loguj extends AppCompatActivity {

    String wartosc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguj);
        Button button = findViewById(R.id.profilx);

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


    public void profil() {


//        StringBuilder builder = new StringBuilder();
//        for(String s : fileList()) {
//            builder.append(s);
//        }
//        String str = builder.toString();
//


        try {
            FileInputStream fileInputStream = openFileInput("Kozak");
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
