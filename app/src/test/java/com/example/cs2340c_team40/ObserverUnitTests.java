package com.example.cs2340c_team40;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Subscriber;

public class ObserverUnitTests {

    @Test
    public void testFollowsObserverPattern() {
        Player p = Player.getInstance();
        assertEquals(p instanceof Player, true);
        assertEquals(p instanceof Subscriber, true);
    }

    @Test
    public void testUpdate() {
        Player p1 = Player.getInstance();
        Player p2 = Player.getInstance();
        p1.update();
        assertEquals(p1.getX(), p2.getX());
        assertEquals(p2.getY(), p1.getY());
    }

}
