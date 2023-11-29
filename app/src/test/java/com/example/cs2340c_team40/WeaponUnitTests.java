package com.example.cs2340c_team40;

import static org.junit.Assert.assertEquals;


import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Weapon;

import org.junit.Before;
import org.junit.Test;

public class WeaponUnitTests {

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
