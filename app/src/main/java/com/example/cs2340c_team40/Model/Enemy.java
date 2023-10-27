package com.example.cs2340c_team40.Model;

import android.widget.ImageView;
public class Enemy {
    private String name;
    private int difficulty;
    private int hp;
    private int x;
    private int y;
    private int spriteChoice;
    private boolean moving;
    // Create a variable called EnemyDirection - Observer pattern
    private ImageView sprite;
    private int pixelHeight;
    private int pixelWidth;

    private Enemy() {
        this.name = "";
        this.difficulty = 1;
        this.hp = 15;
        this.x = 0;
        this.y = 0;
        this.spriteChoice = 1;
        this.moving = !true;
        this.pixelHeight = 25;
        this.pixelWidth = 25;
    }

    public String getName() {
        return this.name;
    }
    public int getDifficulty() {
        return this.difficulty;
    }
    public int getHp() {
        return this.hp;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getSpriteChoice() {
        return this.spriteChoice;
    }
    public boolean getMoving() {
        return this.moving;
    }
    public ImageView getSprite() {
        return this.sprite;
    }
    public int getPixelHeight() {
        return this.pixelHeight;
    }

    public int getPixelWidth() {
        return this.pixelWidth;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSpriteChoice(int spriteChoice) {
        this.spriteChoice = spriteChoice;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public void setImageView(ImageView sprite) {
        this.sprite = sprite;
    }
    public void setPixelHeight(int pixelHeight) {
        this.pixelHeight = pixelHeight;
    }
    public void setPixelWidth(int pixelWidth) {
        this.pixelWidth = pixelWidth;
    }
}
