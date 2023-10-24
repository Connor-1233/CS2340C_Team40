package com.example.cs2340c_team40;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.ImageView;

import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Subscriber;



import java.util.ArrayList;

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
        assertEquals(p1.getX(), p2.getX());
        assertEquals(p2.getY(), p1.getY());
    }

    @Test
    public void ObserverTest() {
        Player player = Player.getInstance();
        player.setX(0);
        player.setY(0);
        MoveHorizontal dir = new MoveHorizontal(1);
        player.setMoveDirection(dir);
        dir.movePlayer();
        MoveVertical dirVer = new MoveVertical(1);
        player.setMoveDirection(dirVer);
        dirVer.movePlayer();
        assertEquals(player.getX(), 5);
        assertEquals(player.getY(), 5);
    }
}
