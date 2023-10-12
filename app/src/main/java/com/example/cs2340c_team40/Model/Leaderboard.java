package com.example.cs2340c_team40.Model;
import java.util.ArrayList;

public class Leaderboard {
    private static Leaderboard gameLeaderBoard;
    private ArrayList<Score> rankings;
    private int lowestRankedScore;
    private Leaderboard() {
        rankings = new ArrayList<Score>(5);
    }

    //Updates and sorts the score list with the new score
    public void updateScore(int score, String name) {
        if (rankings.size() >= 5 & score < lowestRankedScore) {
            return;
        }
        Score newScore = new Score(score, name);
        for (int i = 0; i < 5; i++) {
            if (i < rankings.size()) {
                Score currScore = rankings.get(i);
                if (score > currScore.getScore()) {
                    rankings.add(i, newScore);
                    return;
                }
            } else {
                rankings.add(i, newScore);
                return;
            }
        }
    }

    //Method to grab a certain score from the list
    public Score getScore(int index) {
        if (index < rankings.size()) {
            return rankings.get(index);
        } else {
            Score blankScore = new Score(0, null);
            return blankScore;
        }
    }

    //Singleton method to grab one instance of the leaderboard
    public static Leaderboard getInstance() {
        if (gameLeaderBoard == null) {
            gameLeaderBoard = new Leaderboard();
        }
        return gameLeaderBoard;
    }

    public void resetLeaderboard() {
        rankings = new ArrayList<Score>(5);
    }
    //Method to get size
    public int getSize() {
        return rankings.size();
    }
}
