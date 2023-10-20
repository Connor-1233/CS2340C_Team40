package com.example.cs2340c_team40.ViewModel;


import java.util.Timer;
import java.util.TimerTask;
import android.animation.ObjectAnimator;


import androidx.constraintlayout.widget.ConstraintSet;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Room;

public class GameScreenViewModel {
    private static Timer dotTimer = new Timer();
    private static Room room;
    private static Player player = Player.getInstance();

    public static void initializePlayer(int x, int y, Room currRoom) {
        player.setHealth(calculateHealth(player.getDifficulty()));
        player.setX(x);
        player.setY(y);
        room = currRoom;
        /*
        Timer to call updateLocations to move the player
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
        */
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
    public static int collisionCheck(int playerX, int playerY) {
        return room.checkLocation(playerX, playerY);
    }
    /* Touch Controls
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
    */
}
