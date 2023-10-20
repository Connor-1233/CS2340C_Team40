package com.example.cs2340c_team40.Model;

public class Player {

    private String name;
    private int score;
    private int health;
    private double difficulty;
    private int spriteChoice;
    private float x;
    private float y;


    private static Player player;

    private Player() {
        difficulty = 0;
        spriteChoice = 0;
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
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }
    public void setSpriteChoice(int spriteChoice) {
        this.spriteChoice = spriteChoice;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getSpriteChoice() {
        return spriteChoice;
    }
    public double getDifficulty() {
        return difficulty;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}