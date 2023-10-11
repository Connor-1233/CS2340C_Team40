package com.example.cs2340c_team40.Model;
import java.util.ArrayList;

public class Leaderboard {
    private static Leaderboard gameLeaderBoard;
    public static ArrayList<Score> rankings;
    private int lowestRankedScore;
    private Leaderboard() {
        ArrayList<Score> rankings = new ArrayList<Score>();
    }

    //Updates and sorts the score list with the new score
    public void updateScore(int score, String name) {
        if (rankings.size() >= 5 & score < lowestRankedScore) {
            return;
        }
        Score newScore = new Score(score, name);
        for (int i = 0; i < 5; i++) {
            Score currScore = rankings.get(i);
            if (score > currScore.getScore()) {
                rankings.add(i, newScore);
                return;
            }
        }
    }

    //Method to grab a certain score from the list
    public Score getScore(int index) {
        return rankings.get(index);
    }

    //Singleton method to grab one instance of the leaderboard
    public static Leaderboard getInstance() {
        if (gameLeaderBoard == null) {
            gameLeaderBoard = new Leaderboard();
        }
        return gameLeaderBoard;
    }
}
