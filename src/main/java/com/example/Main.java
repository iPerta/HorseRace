package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int horseNumber = 100;

        Thread[] horse = new Thread[horseNumber];
        List<Race> races = new ArrayList<>();

        for (int i = 0; i < horseNumber; i++) {
            Race race = new Race(i + 1);
            horse[i] = new Thread(race);
            horse[i].start();
            synchronized (races) {
                races.add(race);
            }
        }

        for (int i = 0; i < horseNumber; i++) {
            try {
                horse[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        races.sort((r1, r2) -> Long.compare(r1.getFinishTime(), r2.getFinishTime()));

        System.out.println("Classifica dei thread:");
        for (int i = 0; i < races.size(); i++) {
            System.out.println("Posizione " + (i + 1) + ": Thread " + races.get(i).getThreadId() + " - Tempo: " + races.get(i).getFinishTime() + " ms");
        }
    }
}