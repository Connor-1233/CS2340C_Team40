package com.example.cs2340c_team40;


import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team40.Model.Enemy;
import com.example.cs2340c_team40.Model.EnemyFactory;
import com.example.cs2340c_team40.Model.MovePattern;
import com.example.cs2340c_team40.Model.PlayerDirection;
import com.example.cs2340c_team40.Model.Subscriber;

import org.junit.Test;

import java.util.ArrayList;

public class EnemyUnitTests {
    @Test
    public void createEnemyValid() {
        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        EnemyFactory enemyCreator = new EnemyFactory();
        //Ghost Enemy
        Enemy ghost = enemyCreator.createEnemy("Ghost");
        ghost.setX(660);
        ghost.setY(860);
        int[] ghostArray = {0,230,0,230};
        PlayerDirection ghostPattern = new MovePattern(ghost, ghostArray, 'a');
        ghost.setMoveDirection(ghostPattern);
        entities.add(ghost);
        for (Subscriber subscriber : entities) {
            subscriber.update();
        }
    }

    @Test
    public void createEnemyUpdate() {
        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        EnemyFactory enemyCreator = new EnemyFactory();
        //Ghost Enemy
        Enemy ghost = enemyCreator.createEnemy("Ghost");
        ghost.setX(660);
        ghost.setY(860);
        int[] ghostArray = {0,230,0,230};
        PlayerDirection ghostPattern = new MovePattern(ghost, ghostArray, 'a');
        ghost.setMoveDirection(ghostPattern);
        entities.add(ghost);
        for (Subscriber subscriber : entities) {
            subscriber.update();
        }
        assertEquals(ghost.getX(), 655);
        assertEquals(ghost.getY(), 860);
    }
}
