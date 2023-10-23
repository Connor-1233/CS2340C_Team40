package com.example.cs2340c_team40.Model;

import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

public class MoveHorizontal implements PlayerDirection {
    private Player player = Player.getInstance();
    private int result;
    private int dir;
    public MoveHorizontal(int dir) {
        this.dir = dir;
    }
    public void movePlayer() {
        if (dir > 0) { //move right
            result = player.getX() + 5;
        } else {
            result = player.getX() - 5;
        }
//        if (0 <= result && result <= 29) {
//            if (GameScreenViewModel.collisionCheck(result, player.getX()) == 0) {
                player.setX(result);
                player.setMoving(true);
//            }
//        }
    }
}