package com.example.cs2340c_team40.Model;

public class EnemyKnight extends Enemy {

    @Override
    public void createMovement() {
        setMoveHorizontal(4);
        setMoveVertical(4);
        setHealth(80);
        setSpriteSize(10);
    }
}
