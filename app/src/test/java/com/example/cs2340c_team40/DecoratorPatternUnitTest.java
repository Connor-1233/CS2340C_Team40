package com.example.cs2340c_team40;

import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team40.Model.DamagePowerUpDecorator;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.PowerUp;
import com.example.cs2340c_team40.Model.PowerUpItem;
import com.example.cs2340c_team40.Model.ScorePowerUpDecorator;

import org.junit.Test;

public class DecoratorPatternUnitTest {
    @Test
    public void testDamagePowerUpDecorator() {
        Player player = Player.getInstance();

        PowerUp p = new DamagePowerUpDecorator(new PowerUpItem(), player);
        p.updatePowerUpEffect();
        assertEquals(35, player.getDamage());
    }
    @Test
    public void testScorePowerUpDecorator() {
        Player player = Player.getInstance();
        assertEquals(0, player.getScore());

        PowerUp p = new ScorePowerUpDecorator(new PowerUpItem(), player);
        p.updatePowerUpEffect();
        assertEquals(100, player.getScore());
    }
}