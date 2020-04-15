package com.obarra.proventesting.concurrent;

public class StupidCounter {
    private int firstCounter = 0;
    private int secondCounter = 0;

    public void addFirstCounter() {
        System.out.println("add " + firstCounter);
        firstCounter = firstCounter + 1;
    }

    public synchronized void addFirstCounterLevelInstanceMethod()  {
        try {
            Thread.sleep(100L);
            System.out.println("addFirstCounterLevelInstanceMethod " + firstCounter);
            firstCounter = firstCounter + 1;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addFirstCounterLevelBlockCode()  {
        synchronized (this) {
            try {
                Thread.sleep(100L);
                System.out.println("addFirstCounterLevelBlockCode " + firstCounter);
                firstCounter = firstCounter + 1;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void addSecondCounterLevelInstanceMethod() {
        System.out.println("addSecondCounterLevelInstanceMethod " + secondCounter);
        secondCounter = secondCounter + 1;
    }

    public void addSecondCounterLevelBlockCode() {
        synchronized (this) {
            System.out.println("addSecondCounterLevelInstanceMethod "+ secondCounter);
            secondCounter = secondCounter + 1;
        }
    }

    public int getFirstCounter() {
        return firstCounter;
    }

    public int getSecondCounter() {
        return secondCounter;
    }
}
