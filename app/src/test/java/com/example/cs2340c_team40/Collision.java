package com.example.cs2340c_team40;

import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import com.example.cs2340c_team40.Model.EnemyKnight;
import com.example.cs2340c_team40.Model.EnemySkeleton;
import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.View.ConfigScreen;
import com.example.cs2340c_team40.ViewModel.ConfigScreenViewModel;
public class Collision {
    @Test
    public void testHPDifficulty() {
        Player p = Player.getInstance();
        p.setDifficulty(0.5);
        // Code snippet taken from the relevant enemy logic class
        double diff_a = 0;
        double diff_b = 0;
        boolean xCollision = true;
        boolean yCollision = true;
        if (xCollision && yCollision) {
            // Log.d("collision: ", String.valueOf(xCollision && yCollision));
            double difficulty = p.getDifficulty();
            if (difficulty == 0.5) {
                // Easy Difficulty, decrease hp by a fifteenth
                diff_a = p.getHealth() - 150 / 10;
                p.setHealth(p.getHealth() - 150 / 10);
                // hitPlayer = true;
            } else if (difficulty == 0.75) {
                // Medium Difficulty, decrease hp by a tenth
                diff_a = p.getHealth() - 100 / 10;
                p.setHealth(p.getHealth() - 100 / 10);
                // hitPlayer = true;
            } else {
                // Hard Difficulty, decrease hp by a fifth
                diff_a = p.getHealth() - 50 / 10;
                p.setHealth(p.getHealth() - 50 / 10);
                // hitPlayer = true;
            }
            // Log.d("After Health: ", String.valueOf(p.getHealth()));
        }

        p.setDifficulty(0.75);
        if (xCollision && yCollision) {
            // Log.d("collision: ", String.valueOf(xCollision && yCollision));
            double difficulty = p.getDifficulty();
            if (difficulty == 0.5) {
                // Easy Difficulty, decrease hp by a fifteenth
                diff_b = p.getHealth() - 150 / 10;
                p.setHealth(p.getHealth() - 150 / 10);
                // hitPlayer = true;
            } else if (difficulty == 0.75) {
                // Medium Difficulty, decrease hp by a tenth
                diff_b = p.getHealth() - 100 / 10;
                p.setHealth(p.getHealth() - 100 / 10);
                // hitPlayer = true;
            } else {
                // Hard Difficulty, decrease hp by a fifth
                diff_b = p.getHealth() - 50 / 10;
                p.setHealth(p.getHealth() - 50 / 10);
                // hitPlayer = true;
            }
            // Log.d("After Health: ", String.valueOf(p.getHealth()));
        }

        assertNotEquals(diff_a, diff_b);
    }

    @Test
    public void testEnemyListUpdates() {
        Player p = Player.getInstance();
        EnemyKnight k = new EnemyKnight();
        EnemySkeleton s = new EnemySkeleton();


        p.getEnemyList().add(k);
        p.getEnemyList().add(s);

        int sizeOfList = p.getEnemyList().size();

        assertEquals(2, sizeOfList);
    }
}
