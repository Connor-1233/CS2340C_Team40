package com.example.cs2340c_team40.Model;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Weapon implements Subscriber {
    private Player player = Player.getInstance();
    private int x;
    private int y;
    private ImageView sprite;
    private List<Enemy> enemyList = new ArrayList<>();
    private static Weapon weapon;

    // The Weapon class is a Singleton and follows the Observer Pattern with the Enemies
    // being the ones informed.

    private Weapon() {


    }
    public static Weapon getInstance() {
        if (weapon == null) {
            synchronized (Player.class) {
                if (weapon == null) {
                    weapon = new Weapon();
                }
            }
        }
        return weapon;
    }

    @Override
    public void update() {

    }

    public void notifyEnemies() {
        for (Enemy e : enemyList) {
            e.weaponCollision();
        }
    }



    @Override
    public void setX(int x) {
        this.x = x;
        notifyEnemies();
    }

    @Override
    public void setY(int y) {
        this.y = y;
        notifyEnemies();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
