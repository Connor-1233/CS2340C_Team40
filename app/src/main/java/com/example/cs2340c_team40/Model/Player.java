package com.example.cs2340c_team40.Model;

public class Player implements Subscriber {

    private String name;
    private int score;
    private int health;
    private double difficulty;
    private int spriteChoice;
    private int x;
    private int y;
    private boolean moving;
    private PlayerDirection playerDirection;


    private static Player player;

    private Player() {
        difficulty = 0;
        spriteChoice = 0;
        moving = false;
    }

    public static Player getInstance() {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player();
                }

            }
        }
        return player;
    }

    public void update() {
        if (moving) {
            playerDirection.movePlayer(1);
            moving = false;
            //draw(player)
        }
    }
    //When button is pressed, set the player direction, then move the player(playerDirection.move()
    public void setMoveDirection(PlayerDirection dir) {
        playerDirection = dir;
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
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
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
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}