package com.example.cs2340c_team40;

import static org.junit.Assert.*;

import com.example.cs2340c_team40.Model.Leaderboard;

import org.junit.Test;

public class LeaderboardUnitTests {
    @Test
    public void AddScoreToLeaderboard() {
        Leaderboard testBoard = Leaderboard.getInstance();
        //Add a first score
        testBoard.updateScore(70, "James");
        assertEquals(testBoard.getScore(0).getScore(), 70);
        assertEquals(testBoard.getScore(0).getName(), "James");
        //Add a second score
        testBoard.updateScore(60, "John");
        assertEquals(testBoard.getScore(0).getScore(), 70);
        assertEquals(testBoard.getScore(0).getName(), "James");
        assertEquals(testBoard.getScore(1).getScore(), 60);
        assertEquals(testBoard.getScore(1).getName(), "John");
        //Add a third score
        testBoard.updateScore(80, "Emily");
        assertEquals(testBoard.getScore(0).getScore(), 80);
        assertEquals(testBoard.getScore(1).getScore(), 70);
        assertEquals(testBoard.getScore(2).getScore(), 60);
    }

    @Test
    public void AddManyScores() {
        Leaderboard testBoard = Leaderboard.getInstance();
        //Add 6 scores
        testBoard.updateScore(10, "A");
        testBoard.updateScore(20, "B");
        testBoard.updateScore(30, "C");
        testBoard.updateScore(40, "D");
        testBoard.updateScore(50, "E");
        testBoard.updateScore(80, "F");
        //Test that scores are sorted
        assertEquals(testBoard.getScore(0).getScore(), 80);
        assertEquals(testBoard.getScore(1).getScore(), 50);
        assertEquals(testBoard.getScore(2).getScore(), 40);
        assertEquals(testBoard.getScore(3).getScore(), 30);
    }

    @Test
    public void isSingleton() {
        
        Leaderboard board1 = Leaderboard.getInstance();
        board1.updateScore(10, "A");
        Leaderboard board2 = Leaderboard.getInstance();
        board2.updateScore(20, "B");
        Leaderboard board3 = Leaderboard.getInstance();
        board3.updateScore(30, "C");
        Leaderboard board4 = Leaderboard.getInstance();
        board4.updateScore(40, "D");

        assertEquals(board1.getSize(), board2.getSize());
        assertEquals(board3.getSize(), board4.getSize());
        assertEquals(board1.getSize(), board4.getSize());

        for (int i = 0; i < board1.getSize(); i++) {
            assertEquals(board1.getScore(i).getName(), board2.getScore(i).getName());
            assertEquals(board3.getScore(i).getName(), board4.getScore(i).getName());
            assertEquals(board1.getScore(i).getName(), board4.getScore(i).getName());
        }
        
    }
}
