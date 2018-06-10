package com.example.dominik.alkotest;

/**
 * * Klasa odpowiadająca za obsługę gry w tescie2
 */


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

    /**
     * polaczenie Test2Gra z konkretnym Test2
     *
     * @param test2 obiekt klasy Test2
     */

    Test2Gra(Test2 test2) {

        this.test2 = test2;
    }

    /**
     * metoda zwraca wartosc sTime w postaci String jako srednia 5
     * porbanych wczesniej wartosci reakcji
     *
     * @return zwracam sredni czas reakcji
     */

    private String getsTime() {
        avg = help / 5;
        sTime = Long.toString((avg));
        return sTime;
    }

    /**
     * getter zwracajacy wartosc String z wartosci long waitingTime
     * @return czas do klikniecia przycisku
     */
    public String getShow() {
        show = Long.toString((waitingTime));
        return show;
    }

    /**
     * metoda wybierajaca randomowy button z klasy Test2
     * wywolanie runWaitingThread()
     * dodawnie poszczegolnych wartosci waitingTime do zmiennej help
     * oraz wywyolanie finishGame z Test2
     */

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

    /**
     * setter ustwiajacy wartosc waitingForClick
     * @param waitingForClick boolean
     */

    public void setWaitingForClick(boolean waitingForClick) {
        this.waitingForClick = waitingForClick;
    }

}
