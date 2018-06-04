package com.example.dominik.alkotest;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.ArrayList;


public class Test2 extends AppCompatActivity {


    private Test2Gra test2Gra;
    private Random randomGenerator;
    private Button randomButton;
    private ArrayList<Button> buttonArrayList;
    volatile private long waitingTime;
    long time;
    Rejestruj rejestruj;

    private View.OnClickListener clicker = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            Button clickedButtonID = findViewById(v.getId());
            if(clickedButtonID==randomButton){
                clickedButtonID.setBackgroundResource(R.drawable.buttonshape);
                test2Gra.setWaitingForClick(false);
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        randomGenerator=new Random();
        buttonArrayList = new ArrayList<>();

        buttonArrayList.add((Button) findViewById(R.id.button1));
        buttonArrayList.add((Button) findViewById(R.id.button2));
        buttonArrayList.add((Button) findViewById(R.id.button3));
        buttonArrayList.add((Button) findViewById(R.id.button4));
        buttonArrayList.add((Button) findViewById(R.id.button5));
        buttonArrayList.add((Button) findViewById(R.id.button6));
        buttonArrayList.add((Button) findViewById(R.id.button7));
        buttonArrayList.add((Button) findViewById(R.id.button8));
        buttonArrayList.add((Button) findViewById(R.id.button9));

        for(int i = 0; i < 9; i++) {
            buttonArrayList.get(i).setOnClickListener(clicker);
        }

        runGame();



    }

    public void chooseRandomButton(){
        int choosenButtonIndex = randomGenerator.nextInt(buttonArrayList.size());
        randomButton = buttonArrayList.get(choosenButtonIndex);
        Test2.this.runOnUiThread(new Runnable(){
            @Override
            public void run() {
                randomButton.setBackgroundResource(R.drawable.target);
            }
        });

    }

    public void runGame()  {
        test2Gra=new Test2Gra(this);
        test2Gra.start();
    }

    public long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void finishGame(){

        Test2.this.runOnUiThread(new Runnable(){
            @Override
            public void run() {
                finish();
            }
        });

        File file = new File(getApplicationContext().getFilesDir(), "time.txt");

        String filename = "Kozak";
        String fileContents = test2Gra.getsTime();
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            Log.v("Test2",test2Gra.getsTime());

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test2","Nie dziala");
        }



    }


}