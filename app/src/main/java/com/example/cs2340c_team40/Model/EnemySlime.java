package com.example.cs2340c_team40.Model;

public class EnemySlime extends Enemy {
    @Override
    public void createMovement() {
        //moves diagonal
        setMoveHorizontal(8);
        setMoveVertical(8);
        setHealth(20);
        setSpriteSize(10);
    }
}
