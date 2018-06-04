package com.example.dominik.alkotest;

public class Test2Thread extends Thread {


    private Test2Gra temp;
    volatile private long mStart;
    volatile private long mEnd;

    public Test2Thread(Test2Gra temp) {
        this.temp = temp;
    }

    @Override
    public void run() {
        mStart = System.currentTimeMillis();
        while (temp.isWaitingForClick()) {}
        mEnd = System.currentTimeMillis();
        long value = mEnd - mStart;
        temp.setWaitingTime(value);
    }


}
