package com.example.cs2340c_team40;

import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.PlayerDirection;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StrategyUnitTests {
    @Before
    public void setUp() {
        Player player = Player.getInstance();
        player.resetPlayerForTesting();
    }
    @Test
    public void StrategyTest() {
        Player p = Player.getInstance();
        GameScreenViewModel.initializePlayer(5,0, new ArrayList<Subscriber>(), StrategyUnitTests.class);
        PlayerDirection dir = new MoveHorizontal(-1);
        p.setMoveDirection(dir);
        dir.movePlayer();
        assertEquals(p.getX(), 0);
    }
}
