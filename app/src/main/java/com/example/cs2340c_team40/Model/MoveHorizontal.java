package com.example.cs2340c_team40.Model;


public class MoveHorizontal implements PlayerDirection {
    private Player player = Player.getInstance();
    private int result;
    private int dir;
    public MoveHorizontal(int dir) {
        this.dir = dir;
    }
    public void movePlayer() {
        result = player.getX();
        if (dir == 1) { //move right
            result += player.getSpeed();
        } else if (dir == -1) {
            result -= player.getSpeed();
        }
        player.setX(result);
        player.setMoving(true);
        dir = 0;
    }
}