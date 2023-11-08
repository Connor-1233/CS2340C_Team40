package com.example.cs2340c_team40.Model;

public class EnemySkeleton extends Enemy {
    @Override
    public void createMovement() {
        this.setHealth(60);
        this.setSpriteSize(10);
    }
}
