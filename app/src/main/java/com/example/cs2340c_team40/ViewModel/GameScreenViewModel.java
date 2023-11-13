package com.example.cs2340c_team40.ViewModel;


import java.util.ArrayList;
import java.util.Timer;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Subscriber;

public class GameScreenViewModel {
    private static Timer dotTimer = new Timer();
    private static Player player = Player.getInstance();
    private static ArrayList<Subscriber> subscribers;

    public static void initializePlayer(int x, int y,
                                        ArrayList<Subscriber> entities) {
        player.setHealth(calculateHealth(player.getDifficulty()));
        player.setX(x);
        player.setY(y);
        subscribers = entities;
        //Timer to call updateLocations to move the player
        //PrimeThread pThread = new PrimeThread(entities);
        //pThread.start();
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
        return 0;
    }
}
