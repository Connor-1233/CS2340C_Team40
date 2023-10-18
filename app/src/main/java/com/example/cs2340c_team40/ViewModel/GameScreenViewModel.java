package com.example.cs2340c_team40.ViewModel;

import android.view.MotionEvent;

import java.util.Timer;
import java.util.TimerTask;


import androidx.constraintlayout.widget.ConstraintSet;

import com.example.cs2340c_team40.Model.Player;

public class GameScreenViewModel {
    private static Timer dotTimer = new Timer();
    private static float dx = 0;
    private static float dy = 0;

    private static Player player = Player.getInstance();

    public static void initializePlayer(float x, float y) {
        player.setHealth(calculateHealth(player.getDifficulty()));
        player.setX(x);
        player.setY(y);
        /*
        Timer to call updateLocations to move the player
         */
        dotTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        updateLocation();
                    }
                });
            }
        }, 0, 100); // Check every .1 seconds
    }
    public static int calculateHealth(double difficultyGame) {
        int health;
        if (difficultyGame == .5) {
            health = 150;
        } else if (difficultyGame == .75) {
            health = 100;
        } else {
            health = 50;
        }
        return health;
    }
    public static void updateTouch(float xx, float yy) {
        float dx = xx - player.getX();
        float dy = yy - player.getY();
    }
    public static void updateLocation() {
        int movex = 0;
        int movey = 0;
        if (dx < 0) {
            dx++;
            movex = 1;
        } else if (dx > 0) {
            dx--;
            movex = -1;
        }
        if (dy < 0) {
            dy++;
            movey = 1;
        } else if (dy > 0) {
            dy--;
            movey = -1;
        }
        player.setY(player.getY() + movey);
        player.setX(player.getX() + movex);
    }
    //calculating scoring will go here
}
