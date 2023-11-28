package com.example.cs2340c_team40.Model;

import android.util.Log;

import java.util.ArrayList;

public class PrimeThread extends Thread {
    private ArrayList<Subscriber> entities;
    public PrimeThread(ArrayList<Subscriber> entities) {
        this.entities = entities;
    }

    public void run() {
        for (Subscriber subscriber : entities) {
            subscriber.update();
            //Log.d("position",  "x: " + subscriber.getX() + " y: " + subscriber.getY());
        }
    }
}
