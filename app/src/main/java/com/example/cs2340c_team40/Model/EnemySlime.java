package com.example.cs2340c_team40.Model;

public class EnemySlime extends Enemy {
    @Override
    public void createMovement() {
        //moves diagonal
        this.setHealth(20);
        this.setSpriteSize(10);
    }
}
