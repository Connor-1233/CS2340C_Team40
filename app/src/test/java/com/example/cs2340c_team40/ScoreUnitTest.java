package com.example.cs2340c_team40;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.ViewModel.ConfigScreenViewModel;

public class ScoreUnitTest {
    @Test
    public void testInitializeNegativeScore() {

        Score testScore = new Score(-4, "test");
        assertEquals(0, testScore.getScore());
    }
    @Test
    public void testUpdateNegativeScore() {
        Score testScore = new Score(-20, "test2");
        testScore.updateScore(30);
        assertEquals(30, testScore.getScore());
        testScore.updateScore(-45);
        assertEquals(0, testScore.getScore());
    }
}
