package com.example.cs2340c_team40.ViewModel;


import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Timer;

import com.example.cs2340c_team40.Model.PLAYER;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.View.EndingScreen;
import com.example.cs2340c_team40.View.Room1;
import com.example.cs2340c_team40.View.Room2;
import com.example.cs2340c_team40.View.Room3;
import com.example.cs2340c_team40.View.WelcomeScreen;

public class GameScreenViewModel {
    private static Timer dotTimer = new Timer();
    private static final Player PLAYER = Player.getInstance();
    private static ArrayList<Subscriber> subscribers;
    private static boolean isFlagBottomRoom1 = false;
    private static boolean isFlagTopRoom1 = false;
    private static boolean isFlagBottomRoom2 = false;
    private static boolean isFlagTopRoom2 = false;
    private static boolean isFlagBottomRoom3 = false;
    private static boolean isFlagTopRoom3 = false;
    public static void initializePlayer(int x, int y,
                                        ArrayList<Subscriber> entities, Class<?> clazz) {
        if (clazz.equals(Room1.class)) {
            PLAYER.setHealth(calculateHealth(PLAYER.getDifficulty()));
        } else {
            PLAYER.setHealth(PLAYER.getHealth());
        }
        PLAYER.setX(x);
        PLAYER.setY(y);
        PLAYER.resetEnemyList();
        subscribers = entities;
        //Timer to call updateLocations to move the PLAYER
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
     * A method that calculates the new x and y coordinates based on the key input.
     * @param keyCode an int that represents W, S, A or D (do nothing with anything else)
     * @param x current x position of the PLAYER
     * @param y current y position of the PLAYER
     * @return an integer array of the new X and new Y variables
     *         the 0th index holds the newX
     *         the 1st index holds the newY
     */
    public static int[] getNewCoordinates(int keyCode, int x, int y) {
        int[] coords = new int[2];
        int newX = x;
        int newY = y;

        switch (keyCode) {
        case KeyEvent.KEYCODE_W:
            newY = newY - PLAYER.getSpeed();
            break;
        case KeyEvent.KEYCODE_S:
            newY = newY + PLAYER.getSpeed();
            break;
        case KeyEvent.KEYCODE_A:
            newX = newX - PLAYER.getSpeed();
            break;
        case KeyEvent.KEYCODE_D:
            newX = newX + PLAYER.getSpeed();
            break;
        default:
            break;
        }

        coords[0] = newX;
        coords[1] = newY;
        return coords;
    }

    /**
     * A method that checks whether a PLAYER can move. It performs collision detection
     * with walls.
     * @param clazz class the PLAYER is in for the specific collision detection
     * @param newX the calculated new X variable from a key input
     * @param newY the calculated new Y variable from a key input
     * @return true if the PLAYER should move, false if a PLAYER will collide into a wall
     */
    public static boolean shouldPlayerMove(Class<?> clazz, int newX, int newY) {

        boolean shouldMove = false;

        if (clazz.equals(Room1.class)) {
            shouldMove = newY <= 1000 && newY >= 605 && newX >= 380 && newX <= 685;
        } else if (clazz.equals(Room2.class)) {
            if (newY <= 1415 && newY >= 1320 && newX >= 625 && newX <= 645) { //entry way
                shouldMove = true;
            } else if (newY >= 1210 && newY <= 1320 && newX == 640) { //hallway
                shouldMove = true;
            } else if (newX >= 590 && newX <= 680 && newY <= 1210 && newY >= 975) {
                //room after hallway
                shouldMove = true;
            } else if (newX >= 650 && newX <= 680 && newY <= 975 && newY >= 860) { //passing door
                shouldMove = true;
            } else if (newX >= 200 && newX <= 685 && newY <= 860 && newY >= 525) { //big room
                shouldMove = true;
            }
        } else if (clazz.equals(Room3.class)) {
            if (newY <= 1550 && newY >= 1050 && newX >= 375 && newX <= 545) { //first room
                shouldMove = true;
            } else if (newY >= 910 && newY <= 1050 && newX >= 400 && newX <= 520) { //hallway
                shouldMove = true;
            } else if (newX >= 265 && newX <= 645 && newY <= 925 && newY >= 325) { //bigRoom
                shouldMove = true;
            } else if (newX >= 640 && newX <= 925 && newY <= 640 && newY >= 595) { //passing door
                shouldMove = true;
            }
        }
        return shouldMove;
    }


    /**
     * A method that will calculate whether a PLAYER's position overlaps or aligns with
     * a power-ups' position. It returns a boolean array because there are two power-ups
     * in each room, thus the first index (index 0) holds whether the power-up closest to the
     * bottom of the screen has been hit. The second index (index 1) holds the boolean of
     * whether the power-up closest to the top of the screen has collided with the PLAYER.
     * @param clazz class the PLAYER is in for the specific collision detection
     * @param newX the calculated new X variable from a key input
     * @param newY the calculated new Y variable from a key input
     * @return boolean array of whether a PLAYER has gained a power-up
     */
    public static boolean[] hasHitPowerUp(Class<?> clazz, int newX, int newY) {
        boolean[] powerUpArray = new boolean[2];

        boolean hitPowerBottom = false; //this is the power-up closest to top of screen
        boolean hitPowerTop = false; //this is the power-up closest to bottom of screen


        if (clazz.equals(Room1.class)) {
            if (newX <= 410 && newY >= 955) {
                if (!isFlagBottomRoom1) {
                    hitPowerBottom = true;
                    isFlagBottomRoom1 = true;
                }
            } else if (newX >= 585 && newX <= 660 && newY >= 605 && newY <= 650) {
                if (!isFlagTopRoom1) {
                    hitPowerTop = true;
                    isFlagTopRoom1 = true;
                }
            }
        } else if (clazz.equals(Room2.class)) {
            if (newX >= 615 && newX <= 680 && newY >= 1085 && newY <= 1170) {
                if (!isFlagBottomRoom2) {
                    hitPowerBottom = true;
                    isFlagBottomRoom2 = true;
                }
            } else if (newX >= 645 && newX <= 685 && newY >= 795 && newY <= 865) {
                if (!isFlagTopRoom2) {
                    hitPowerTop = true;
                    isFlagTopRoom2 = true;
                }
            }
        } else if (clazz.equals(Room3.class)) {
            if (newX >= 430 && newX <= 490 && newY >= 1340 && newY <= 1425) {
                if (!isFlagBottomRoom3) {
                    hitPowerBottom = true;
                    isFlagBottomRoom3 = true;
                }
            } else if (newX >= 435 && newX <= 500 && newY >= 1090 && newY <= 1170) {
                if (!isFlagTopRoom3) {
                    hitPowerTop = true;
                    isFlagTopRoom3 = true;
                }
            }
        }

        powerUpArray[0] = hitPowerBottom;
        powerUpArray[1] = hitPowerTop;
        return powerUpArray; //if PLAYER has hit a powerup
    }

    public static void resetGame() {
        isFlagBottomRoom1 = false;
        isFlagTopRoom1 = false;
        isFlagBottomRoom2 = false;
        isFlagTopRoom2 = false;
        isFlagBottomRoom3 = false;
        isFlagTopRoom3 = false;
        PLAYER.resetPlayer();
    }

    /**
     * Public method that gives information on whether the PLAYER is dead.
     * A PLAYER is dead when there health is less than or equal to 0.
     * @return boolean whether health is dead
     */
    public static boolean isPlayerDead() {
        return PLAYER.getHealth() <= 0;
    }

    public static void handleRestartButtonClick(Activity activity, Timer moveTimer,
                                                Class<?> clazz) {
        Button restart = getButton(activity, clazz);
        restart.setOnClickListener(v -> {
            Intent goRoom3 = new Intent(activity, WelcomeScreen.class);
            moveTimer.cancel();
            activity.startActivity(goRoom3);
        });
    }

    public static Button getButton(Activity activity, Class<?> clazz) {
        Button restart;
        if (clazz.equals(Room1.class)) {
            restart = activity.findViewById(R.id.NextRoom1);
        } else if (clazz.equals(Room2.class)) {
            restart = activity.findViewById(R.id.NextRoom2);
        } else {
            restart = activity.findViewById(R.id.NextRoom3);
        }
        return restart;
    }

    public static void handleEndButtonClick(Activity activity, Timer moveTimer) {
        Button restart = activity.findViewById(R.id.go_end_screen_button);
        restart.setOnClickListener(v -> {
            Intent goRoom3 = new Intent(activity, EndingScreen.class);
            moveTimer.cancel();
            activity.startActivity(goRoom3);
        });
    }

    public static void launchGameLoseScreen(Activity activity, Timer moveTimer) {
        moveTimer.cancel();
        Intent intent = new Intent(activity, EndingScreen.class);
        activity.startActivity(intent);
    }

    public static void launchRoom2(Activity activity, Timer moveTimer) {
        moveTimer.cancel();
        Intent intent = new Intent(activity, Room2.class);
        activity.startActivity(intent);
    }

    public static void launchRoom3(Activity activity, Timer moveTimer) {
        moveTimer.cancel();
        Intent intent = new Intent(activity, Room3.class);
        activity.startActivity(intent);
    }
}
