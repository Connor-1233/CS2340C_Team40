package com.example.cs2340c_team40.Model;

import android.util.Log;
import android.widget.ImageView;

public abstract class Enemy implements Subscriber {
    private int spriteSize;
    private int health;
    private int x;
    private int y;
    private boolean moving;

    private PlayerDirection enemyDirection;
    private Player p;
    private ImageView sprite;
    private int pixelHeight;
    private int pixelWidth;
    private boolean enemyDestroyed;

    public Enemy() {
        this.p = Player.getInstance();
        enemyDestroyed = false;
    }

    public void playerCollision() {
        if (!enemyDestroyed) {
            boolean xCollision = p.getX() >= (x - 30) && p.getX() <= (x + 30);
            // Log.d("xCollision", String.valueOf(xCollision));
            boolean yCollision = p.getY() >= (y - 30) && p.getY() <= (y + 30);
            // Log.d("yCollision", String.valueOf(yCollision));
            boolean hitPlayer = false;
            if (xCollision && yCollision) {
                // Log.d("collision: ", String.valueOf(xCollision && yCollision));
                double difficulty = p.getDifficulty();
                //Log.d("Before Health : ", String.valueOf(p.getHealth()));
                if (difficulty == 0.5) {
                    // Easy Difficulty, decrease hp by a fifteenth
                    p.setHealth(p.getHealth() - 10);
                    hitPlayer = true;
                } else if (difficulty == 0.75) {
                    // Medium Difficulty, decrease hp by a tenth
                    p.setHealth(p.getHealth() - 15);
                    hitPlayer = true;
                } else {
                    // Hard Difficulty, decrease hp by a fifth
                    p.setHealth(p.getHealth() - 20);
                    hitPlayer = true;
                }
                //Log.d("After Health: ", String.valueOf(p.getHealth()));
            }
            if (hitPlayer) {
                p.setY(p.getY() + 30);
                // Room 1 - 530, 1000
                // Room 2 - 640, 1415
                // Room 3 - 460, 1550
                hitPlayer = false;
            }
        }
    }

    public void weaponCollision(int weaponX, int weaponY) {
        boolean xCollision = weaponX >= (x - 30) && weaponX <= (x + 30);
        boolean yCollision = weaponY >= (y - 30) && weaponY <= (y + 30);
        if (xCollision && yCollision) {
            enemyDestroyed = true;
        }
    }


    public void update() {
        enemyDirection.movePlayer();
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
    public int getPixelWidth() {
        return pixelWidth;
    }
    public int getPixelHeight() {
        return pixelHeight;
    }
    public void setPixelHeight(int pixelHeight) {
        this.pixelHeight = 20;
    }
    public void setPixelWidth(int pixelWidth) {
        this.pixelWidth = 20;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }
    public ImageView getSprite() {
        return sprite;
    }

}
