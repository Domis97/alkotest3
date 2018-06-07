package com.example.dominik.alkotest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;

public class Rejestruj extends AppCompatActivity {

    String Imie;
    private Test2Gra test2Gra;
    public String getImie() {
        return Imie;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestruj);
    }

    public void test1(View view) {

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Test1.class);
        startActivity(myIntent);

    }

    public void test2(View view) {

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Test2.class);
        startActivity(myIntent);

    }

    public void zapisz(View view) {
        Button save = findViewById(R.id.zapisz);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getApplicationContext().getFilesDir(), "time.txt");

                String filename = "Kozak";
                String fileContents = test2Gra.getsTime();
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    outputStream.write(fileContents.getBytes());
                    outputStream.close();
                    Log.v("Test2", "Do pliku " + test2Gra.getsTime());

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Test2", "Nie dziala zapis");
                }

            }
        });

    }
}

