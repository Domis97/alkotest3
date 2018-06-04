package com.example.dominik.alkotest;
//Write to file to problem nie wiadomo jak to ma działac i czym jest context
import android.content.Context;
import android.util.Log;


public class Test2Gra extends Thread {


    private static final int ILOSCPROB=5;
    volatile private boolean waitingForClick;
    private Thread waitingThread;
    private long waitingTime;
    String sTime;

    public String getsTime() {
        return sTime;
    }

    public long[] getSaveWaitingTime() {
        return saveWaitingTime;
    }

    public void setSaveWaitingTime(long[] saveWaitingTime) {
        this.saveWaitingTime = saveWaitingTime;
    }

    private long [] saveWaitingTime = new long[ILOSCPROB];
    private Test2 test2;

    public Test2Gra(Test2 test2) {
        this.test2 = test2;
    }

    @Override
    public void run() {
        for (int i = 0; i < ILOSCPROB; i++) {
            test2.chooseRandomButton();
            runWaitingThread();
            saveWaitingTime[i]=waitingTime;
            Log.v("TEST 2 GRA", "Zwrocona wartosc " + saveWaitingTime[i]);
            sTime = Long.toString((waitingTime));
        }

        test2.finishGame();
    }



    public void runWaitingThread() {
        waitingForClick = true;
        waitingThread = new Test2Thread(this);
        waitingThread.start();
        try {
            waitingThread.join();
            test2.setWaitingTime(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2.setWaitingTime(waitingTime);

    }


    public boolean isWaitingForClick() {
        return waitingForClick;
    }

    public void setWaitingForClick(boolean waitingForClick) {
        this.waitingForClick = waitingForClick;
    }

    public long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(long waitingTime) {
        this.waitingTime = waitingTime;
    }
}
