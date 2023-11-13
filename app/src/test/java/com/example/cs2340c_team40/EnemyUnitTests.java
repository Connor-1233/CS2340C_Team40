package com.example.cs2340c_team40;

import static org.junit.Assert.*;
import com.example.cs2340c_team40.Model.Enemy;
import com.example.cs2340c_team40.Model.EnemyFactory;

import org.junit.Test;

public class EnemyUnitTests {
    @Test
    public void testFactorySkeleton() {
        EnemyFactory factory = new EnemyFactory();
        Enemy e = factory.createEnemy("Skeleton");

        assertEquals(60, e.getHealth());
        assertEquals(10, e.getSpriteSize());
    }
    @Test
    public void testInvalidEnemyType() {
        EnemyFactory factory = new EnemyFactory();
        Enemy e = factory.createEnemy("Bat");

        assertEquals(null, e);
    }
}
