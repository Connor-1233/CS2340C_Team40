package com.example.cs2340c_team40.Model;

public class EnemyFactory extends Enemy {
    public Enemy createEnemy(String enemyString) {
        Enemy enemy = null;
        if (enemyString.equals("Ghost")) {
            enemy = new EnemyGhost();
            enemy.createMovement();
        } else if (enemyString.equals("Knight")) {
            enemy = new EnemyKnight();
            enemy.createMovement();
        } else if (enemyString.equals("Skeleton")) {
            enemy = new EnemySkeleton();
            enemy.createMovement();
        } else if (enemyString.equals("Slime")) {
            enemy = new EnemySlime();
            enemy.createMovement();
        } else {
            System.out.println("invalid enemy type");
        }
        return enemy;
    }

    @Override
    public void createMovement() {

    }
}
