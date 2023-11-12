package com.example.cs2340c_team40.Model;

public class EnemyKnight extends Enemy {

    @Override
    public void createMovement() {
        this.setHealth(80);
        this.setSpriteSize(10);
    }
}
