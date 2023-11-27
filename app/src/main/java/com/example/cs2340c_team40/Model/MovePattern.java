package com.example.cs2340c_team40.Model;

public class MovePattern implements PlayerDirection {
    private Subscriber enemy;
    private int[] pattern; //A pattern defined by [up,right,down,left]
    private char dir;
    private int dirProgress = 0;
    public MovePattern(Subscriber enemy, int[] pattern, char dir) {
        this.enemy = enemy;
        this.pattern = pattern;
        this.dir = dir;
    }
    public char movePlayer() {
        switch (dir) {
        case 'w':
            dirProgress += 5;
            if (dirProgress <= pattern[0]) {
                enemy.setY(enemy.getY() - 5);
            } else {
                dir = 'd';
                dirProgress = 0;
            }
            break;
        case 'd':
            dirProgress += 5;
            if (dirProgress <= pattern[1]) {
                enemy.setX(enemy.getX() + 5);
            } else {
                dir = 's';
                dirProgress = 0;
            }
            break;
        case 's':
            dirProgress += 5;
            if (dirProgress <= pattern[2]) {
                enemy.setY(enemy.getY() + 5);
            } else {
                dir = 'a';
                dirProgress = 0;
            }
            break;
        case 'a':
            dirProgress += 5;
            if (dirProgress <= pattern[3]) {
                enemy.setX(enemy.getX() - 5);
            } else {
                dir = 'w';
                dirProgress = 0;
            }
            break;
        default:
            break;
        }
        return dir;
    }
}
