package com.example.cs2340c_team40.ViewModel;


import android.view.KeyEvent;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Room;
import com.example.cs2340c_team40.Model.Subscriber;

public class GameScreenViewModel {
    private static Timer dotTimer = new Timer();
    private static Room room;
    private static Player player = Player.getInstance();
    private static ArrayList<Subscriber> subscribers;

    public static void initializePlayer(int x, int y, Room currRoom, ArrayList<Subscriber> entities) {
        player.setHealth(calculateHealth(player.getDifficulty()));
        player.setX(x);
        player.setY(y);
        room = currRoom;
        subscribers = entities;
        //Timer to call updateLocations to move the player
        dotTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (Subscriber subscriber : subscribers) {
                            subscriber.update();
                        }
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
    public static int collisionCheck(int playerX, int playerY) {
        return room.checkLocation(playerX, playerY);
    }

//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode) {
//        case KeyEvent.KEYCODE_W: //moves player up
//            player.setPlayerDirIndex(1);
//            break;
//        case KeyEvent.KEYCODE_A: //moves player left
//            player.setPlayerDirIndex(-1);
//            break;
//        case KeyEvent.KEYCODE_S: //moves player down
//            player.setPlayerDirIndex(-1);
//            break;
//        case KeyEvent.KEYCODE_D: //moves player right
//            player.setPlayerDirIndex(1);
//            break;
//        default:
//            player.setX(player.getX());
//            player.setY(player.getY());
//        }
//        return true;
//    }

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
