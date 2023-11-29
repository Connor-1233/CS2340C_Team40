package com.example.cs2340c_team40;

import static org.junit.Assert.assertEquals;


import com.example.cs2340c_team40.Model.Enemy;
import com.example.cs2340c_team40.Model.EnemyFactory;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.PlayerDirection;
import com.example.cs2340c_team40.Model.Weapon;

import org.junit.Before;
import org.junit.Test;

public class WeaponUnitTests {

    @Test
    public void testWeaponNoDirection() {
        EnemyFactory enemyCreator = new EnemyFactory();
        Weapon w = Weapon.getInstance();
        Player p = Player.getInstance();
        Enemy e = enemyCreator.createEnemy("Ghost");
        p.getEnemyList().add(e);
        p.setX(100);
        p.setY(100);
        e.setX(180);
        e.setY(100);
        w.notifyEnemies();
        assertEquals(false, e.isEnemyDestroyed());
    }

    @Test
    public void testWeaponDirection() {
        EnemyFactory enemyCreator = new EnemyFactory();
        Weapon w = Weapon.getInstance();
        Player p = Player.getInstance();
        Enemy e = enemyCreator.createEnemy("Ghost");
        p.getEnemyList().add(e);
        p.setX(100);
        p.setY(100);
        e.setX(190);
        e.setY(100);
        PlayerDirection mh = new MoveHorizontal(1);
        p.setMoveDirection(mh);
        p.setSpeed(10);
        mh.movePlayer();
        w.notifyEnemies();
        assertEquals('.', p.getDirection());
        assertEquals(110, p.getX());
    }

    @Before
    public void setUp() {
        Player player = Player.getInstance();
        player.resetPlayerForTesting();
    }
    @Test
    public void isWeaponSingleton() {
        Weapon w1 = Weapon.getInstance();
        Weapon w2 = Weapon.getInstance();
        w1.setX(55);
        w2.setX(45);
        assertEquals(w1.getX(), w2.getX());
    }

    @Test
    public void testWeaponDirectionLogic() {
        Player player = Player.getInstance();
        char direction = player.getDirection();
        // enemyList = player.getEnemyList();
        int weaponX = player.getX();
        int weaponY = player.getY();
        if (direction == 'w') {
            weaponY -= 60;
        } else if (direction == 's') {
            weaponY += 60;
        } else if (direction == 'a') {
            weaponX -= 60;
        } else if (direction == 'd') {
            weaponX += 60;
        }
//        for (Enemy e : enemyList) {
//            e.weaponCollision(weaponX,weaponY);
//        }
        assertEquals(weaponX, player.getX());
        weaponX += 60;
        player.setX(player.getX() + 60);
        assertEquals(weaponX, player.getX());
    }
}
