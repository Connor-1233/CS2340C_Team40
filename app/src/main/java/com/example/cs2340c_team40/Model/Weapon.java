package com.example.cs2340c_team40.Model;

import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Weapon implements Subscriber {
    private int x;
    private int y;
    private ImageView sprite;
    private List<Enemy> enemyList = new ArrayList<>();
    private static Weapon weapon;

    // The Weapon class is a Singleton and follows the Observer Pattern with the Enemies
    // being the ones informed.


    public static Weapon getInstance() {
        if (weapon == null) {
            synchronized (Weapon.class) {
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
        Player player = Player.getInstance();
        char direction = player.getDirection();
        Log.d("Weapon direction", String.valueOf(direction));
        enemyList = player.getEnemyList();
        int weaponX = player.getX();
        int weaponY = player.getY();
        if (direction == 'w') {
            weaponY -= 60;
        } else if (direction == 's') {
            weaponY += 60;
        } else if (direction == 'a') {
            weaponX -= 60;
        } else if (direction == 'd') {
            weaponX += 60;
        }
        for (Enemy e : enemyList) {
            e.weaponCollision(weaponX,weaponY);
        }
    }



    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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
