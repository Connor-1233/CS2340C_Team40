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
            result += 5;
        } else if (dir == -1) {
            result -= 5;
        }
        player.setX(result);
        player.setMoving(true);
        dir = 0;
    }
}