package com.example.cs2340c_team40.Model;

import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

public class MoveVertical implements PlayerDirection {
    private Player player = Player.getInstance();
    private int result;
    private int dir;
    public MoveVertical(int dir) {
        this.dir = dir;
    }
    public void movePlayer() {
        if (dir > 0) { //move down
            result = player.getY() + 1;
        } else {
            result = player.getY() - 1;
        }
        if (0 <= result && result <= 31) {
            if (GameScreenViewModel.collisionCheck(result, player.getY()) == 0) {
                player.setY(result);
                player.setMoving(true);

            }
        }
    }
}
