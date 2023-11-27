package com.example.cs2340c_team40.Model;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Player implements Subscriber {

    private String name;
    private int score; //power up
    private int health; //power up
    private int damage; //power up
    private int speed;
    private double difficulty;
    private int spriteChoice;
    private int x;
    private int y;
    private boolean moving;
    private PlayerDirection playerDirection;
    private ImageView sprite;
    private int pixelHeight;
    private int pixelWidth;
    private int arrayX;
    private int arrayY;
    private char direction;
    private List<Enemy> enemyList = new ArrayList<>();
    private static Player player;
    private static Weapon weapon;

    private Player() {
        difficulty = 0;
        spriteChoice = 0;
        damage = 20;
        moving = false;
        weapon = Weapon.getInstance();
        direction = '.';
        speed = 5;
        score = 0;
    }
    public void notifyEnemies() {
        for (Enemy e : enemyList) {

            e.playerCollision();
        }
    }
    public static Player getInstance() {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player();
                    player.setMoveDirection(new MoveHorizontal(0));
                }
            }
        }
        return player;
    }

    public void update() {
        char newDirection = playerDirection.movePlayer();
        if (newDirection != '.') {
            direction = newDirection;
        }
        sprite.setX(x);
        sprite.setY(y);
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
        notifyEnemies();
        weapon.setX(x);
        // Sets the x-value to that of the Player (make sure there is some offset)
    }
    public void setY(int y) {
        this.y = y;
        notifyEnemies();
        weapon.setY(y);
        // Sets the y-value to that of the Player (make sure there is some offset so that the weapon shows)
    }
    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public void setPixelHeight(int pixelHeight) {
        this.pixelHeight = pixelHeight;
    }
    public void setPixelWidth(int pixelWidth) {
        this.pixelWidth = pixelWidth;
    }
    public void setArrayX(int arrayX) {
        this.arrayX = arrayX;
    }
    public void setArrayY(int arrayY) {
        this.arrayY = arrayY;
    }

    public int getScore() {
        return score;
    }
    public char getDirection() {
        return direction;
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
    public ImageView getSprite() {
        return sprite;
    }
    public int getArrayX() {
        return arrayX;
    }
    public int getArrayY() {
        return arrayY;
    }

    public int getPixelHeight() {
        return pixelHeight;
    }

    public int getPixelWidth() {
        return pixelWidth;
    }

    public void resetEnemyList() {
        enemyList = new ArrayList<>();
    }
    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}