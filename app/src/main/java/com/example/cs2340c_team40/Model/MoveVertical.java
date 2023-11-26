package com.example.cs2340c_team40.Model;

public class MoveVertical implements PlayerDirection {
    private Player player = Player.getInstance();
    private int result;
    private int dir;
    public MoveVertical(int dir) {
        this.dir = dir;
    }
    public void movePlayer() {
        result = player.getY();
        if (dir == 1) { //move down
            result += player.getSpeed();
        } else if (dir == -1) {
            result -= player.getSpeed();
        }
        player.setY(result);
        player.setMoving(true);
        dir = 0;
    }
}
