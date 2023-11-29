package com.example.cs2340c_team40.Model;

import android.widget.ImageView;

public abstract class Enemy implements Subscriber {
    private int spriteSize;
    private int health;
    private int x;
    private int y;
    private boolean moving;

    private PlayerDirection enemyDirection;
    private final Player p;
    private ImageView sprite;
    private int pixelHeight;
    private int pixelWidth;
    private boolean enemyDestroyed;

    public Enemy() {
        this.p = Player.getInstance();
        enemyDestroyed = false;
    }

    public void playerCollision() {
        if (this.isEnemyDestroyed()) {
            return;
        }
        boolean xCollision = p.getX() >= (x - 50) && p.getX() <= (x + 50);
        boolean yCollision = p.getY() >= (y - 50) && p.getY() <= (y + 50);

        boolean hitPlayer = false;
        if (xCollision && yCollision) {
            double difficulty = p.getDifficulty();
            if (difficulty == 0.5) {
                // Easy Difficulty, decrease hp by 10, decrease score by 5
                p.setHealth(p.getHealth() - 10);
                p.setScore(p.getScore() - 5);
                hitPlayer = true;
            } else if (difficulty == 0.75) {
                // Medium Difficulty, decrease hp by 15, decrease score by 10
                p.setHealth(p.getHealth() - 15);
                p.setScore(p.getScore() - 10);
                hitPlayer = true;
            } else {
                // Hard Difficulty, decrease hp by 20, decrease score by 15
                p.setHealth(p.getHealth() - 20);
                p.setScore(p.getScore() - 15);
                hitPlayer = true;
            }
        }
        if (hitPlayer) {
            p.setY(p.getY() + 30);
            // Room 1 - 530, 1000
            // Room 2 - 640, 1415
            // Room 3 - 460, 1550
            hitPlayer = false;
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
    public boolean isEnemyDestroyed() {
        return enemyDestroyed;
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
