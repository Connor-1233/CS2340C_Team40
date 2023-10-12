package com.example.cs2340c_team40.Model;

public class Player {

    private String name;
    private int score;

    private static Player player;

    private Player() {

    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
}