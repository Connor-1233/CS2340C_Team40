package com.example.cs2340c_team40.ViewModel;

import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintSet;

import com.example.cs2340c_team40.Model.Player;

public class GameScreenViewModel {
    private static Player player = Player.getInstance();

    public static void initializePlayer(float x, float y) {
        player.setHealth(calculateHealth(player.getDifficulty()));
        player.setX(x);
        player.setY(y);
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
    //calculating scoring will go here
}
