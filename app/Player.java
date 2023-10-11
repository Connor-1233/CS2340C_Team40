package com.example.cs2340c_team40.Model;

public class Player {

    private String username;
    private Score score;

    private static Player player;

    private Player() {

    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }
}
