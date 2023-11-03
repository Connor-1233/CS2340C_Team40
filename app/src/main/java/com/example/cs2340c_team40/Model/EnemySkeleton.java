package com.example.cs2340c_team40.Model;

public class EnemySkeleton extends Enemy {
    @Override
    public void createMovement() {
        setMoveHorizontal(2);
        setMoveVertical(0);
        setHealth(60);
        setSpriteSize(10);
    }
}
