package com.example.dominik.alkotest;



public class Test2Gra extends Thread {


    private static final int ILOSCPROB = 5;
    volatile private boolean waitingForClick;
    private long waitingTime;
    private String show;
    private long help;
    private String sTime;
    private long avg;
    private Test2 test2;
    volatile private long mStart;
    volatile private long mEnd;

    public Test2Gra(Test2 test2) {
        this.test2 = test2;
    }

    public String getsTime() {
        avg = help / 5;
        sTime = Long.toString((avg));
        return sTime;
    }

    public String getShow() {
        show = Long.toString((waitingTime));
        return show;
    }

    @Override
    public void run() {
        for (int i = 0; i < ILOSCPROB; i++) {
            test2.chooseRandomButton();
            runWaitingThread();
            help = help + waitingTime;
        }

        test2.finishGame(getsTime());
    }


    private void runWaitingThread() {
        waitingForClick = true;
        mStart = System.currentTimeMillis();
        while (waitingForClick) {
        }
        mEnd = System.currentTimeMillis();
        waitingTime = mEnd - mStart;
        test2.setWaitingTime(waitingTime);


    }


    public boolean isWaitingForClick() {
        return waitingForClick;
    }

    public void setWaitingForClick(boolean waitingForClick) {
        this.waitingForClick = waitingForClick;
    }

}
