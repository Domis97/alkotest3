package com.example.dominik.alkotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Klasa odpowiadająca za obsługę ekranu startowego
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * Przelaczenie do ekranu rejestrowania nowego konta przez przycisk
     */

    public void rejestruj (View view){

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Rejestruj.class);
        startActivity(myIntent);


    }

    /**
     * Przelaczenie do ekranu loguj przez przycisk
     */

    public void loguj (View view){

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), TestPo.class);
        startActivity(myIntent);

    }

    /**
     * Przelaczenie do ekranu usuwania konta przez przycisk
     */

    public void usun(View view) {

        android.content.Intent myIntent = new android.content.Intent(view.getContext(), Usun.class);
        startActivity(myIntent);

    }
}
