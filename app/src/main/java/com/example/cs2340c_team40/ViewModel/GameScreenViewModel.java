package com.example.cs2340c_team40.ViewModel;

import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Room;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.R;

public class GameScreenViewModel {
    private static Timer dotTimer = new Timer();
    private static Room room;
    private static Player player = Player.getInstance();
    private static ArrayList<Subscriber> subscribers;

    public static void initializePlayer(int x, int y, Room currRoom,
                                        ArrayList<Subscriber> entities) {
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

    /**
     * Public method that gives information on whether the player is dead.
     * A player is dead when there health is less than or equal to 0.
     * @return boolean whether health is dead
     */
    public static boolean isPlayerDead() {
        return player.getHealth() <= 0;
    }

    public static int collisionCheck(int playerX, int playerY) {
        return room.checkLocation(playerX, playerY);
    }
}
