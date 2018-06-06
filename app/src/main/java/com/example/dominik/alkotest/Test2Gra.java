package com.example.dominik.alkotest;



public class Test2Gra extends Thread {


    private static final int ILOSCPROB = 5;
    volatile private boolean waitingForClick;
    private Thread waitingThread;
    private long waitingTime;
    String show;
    private long help;
    String sTime;
    private long avg;
    private Test2 test2;

    public String getsTime() {
        avg = help / 5;
        sTime = Long.toString((avg));
        return sTime;
    }

    public String getShow() {
        show = Long.toString((waitingTime));
        return show;
    }


    public Test2Gra(Test2 test2) {
        this.test2 = test2;
    }

    @Override
    public void run() {
        for (int i = 0; i < ILOSCPROB; i++) {
            test2.chooseRandomButton();
            runWaitingThread();
            help = help + waitingTime;
        }

        test2.finishGame();
    }


    private void runWaitingThread() {
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
