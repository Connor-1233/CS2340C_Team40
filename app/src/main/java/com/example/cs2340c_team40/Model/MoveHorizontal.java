package com.example.cs2340c_team40.Model;


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
        //  if (0 <= result && result <= 29) {
        //  if (GameScreenViewModel.collisionCheck(result, player.getX()) == 0) {
        //  if (GameScreenViewModel.collisionCheck(result / player.getPixelWidth(),
        //  player.getY() / player.getPixelHeight()) == 0) {
        player.setX(result);
        player.setMoving(true);
        //  }
        //  }
    }

    public void moveEnemy() {
        // result = enemy.getX() + enemy.getMoveVertical();
        // result = enemy.getX() - enemy.getMoveVertical();
    }
}