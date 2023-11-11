package com.example.cs2340c_team40.Model;

import android.widget.ImageView;

public abstract class Enemy implements Subscriber {
    private int spriteSize;
    private int health;
    private int x;
    private int y;
    private boolean moving;
    private PlayerDirection enemyDirection;
    private ImageView sprite;
    private int pixelHeight;
    private int pixelWidth;


    public void update() {
        enemyDirection.movePlayer();
        //sprite.setX(x);
        //sprite.setY(y);
    }

    public abstract void createMovement();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int getSpriteSize() {
        return spriteSize;
    }

    public void setSpriteSize(int spriteSize) {
        this.spriteSize = spriteSize;
    }
    public void setMoveDirection(PlayerDirection dir) {
        enemyDirection = dir;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}
