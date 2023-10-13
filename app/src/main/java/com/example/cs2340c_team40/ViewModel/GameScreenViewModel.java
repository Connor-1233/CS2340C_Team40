package com.example.cs2340c_team40.ViewModel;

import com.example.cs2340c_team40.Model.Player;

public class GameScreenViewModel {
    public static void initializePlayer() {
        Player player = Player.getInstance();
        player.setHealth(calculateHealth(player.getDifficulty()));

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
