package com.example.cs2340c_team40.Model;

public class EnemyGhost extends Enemy {

    @Override
    public void createMovement() {
        setMoveHorizontal(0);
        setMoveVertical(3);
        setHealth(40);
        setSpriteSize(10);
    }
}
