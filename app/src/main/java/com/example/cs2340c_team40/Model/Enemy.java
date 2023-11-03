package com.example.cs2340c_team40.Model;

import android.widget.ImageView;

public abstract class Enemy {
    private int moveHorizontal;
    private int moveVertical;
    private int spriteSize;
    private int health;
    private int x;
    private int y;
    private boolean moving;
    private PlayerDirection enemyDirection;
    private ImageView sprite;
    private int pixelHeight;
    private int pixelWidth;

    protected Enemy() {
        moving = false;
    }

    public void update() {
        enemyDirection.moveEnemy();
        sprite.setX(x);
        sprite.setY(y);
    }

    public abstract void createMovement();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoveHorizontal() {
        return moveHorizontal;
    }

    public void setMoveHorizontal(int moveHorizontal) {
        this.moveHorizontal = moveHorizontal;
    }

    public int getMoveVertical() {
        return moveVertical;
    }

    public void setMoveVertical(int moveVertical) {
        this.moveVertical = moveVertical;
    }

    public int getSpriteSize() {
        return spriteSize;
    }

    public void setSpriteSize(int spriteSize) {
        this.spriteSize = spriteSize;
    }
}
