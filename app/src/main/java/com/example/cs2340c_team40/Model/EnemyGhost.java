package com.example.cs2340c_team40.Model;

public class EnemyGhost extends Enemy {

    @Override
    public void createMovement() {
        this.setHealth(40);
        this.setSpriteSize(10);
    }
}
