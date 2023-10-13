package com.example.cs2340c_team40.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Player;
//import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.R;

public class EndingScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);
        Button restartGameBtn = findViewById(R.id.restart_game_btn);
        restartGameBtn.setOnClickListener(v -> restartGame());
        TextView gameScore = findViewById(R.id.textView);

        Player player = Player.getInstance();
        Leaderboard leaderboard = Leaderboard.getInstance();
        gameScore.setText("Final score: " + player.getScore());
        leaderboard.updateScore(player.getScore(), player.getName());

        // Leaderboard
        // Rank 1
        TextView scoreNameOne = findViewById(R.id.score_name_1);
        scoreNameOne.setText((leaderboard.getScore(0) != null)
                                ? leaderboard.getScore(0).getName()
                                : "More Attempts Needed");
        TextView scoreScoreOne = findViewById(R.id.score_score_1);
        scoreScoreOne.setText((leaderboard.getScore(0) != null)
                                ? "" + leaderboard.getScore(0).getScore()
                                : "More Attempts Needed");
        TextView scoreDateOne = findViewById(R.id.score_date_1);
        scoreDateOne.setText((leaderboard.getScore(0) != null)
                                ? leaderboard.getScore(0).getTime()
                                : "More Attempts Needed");
        // Rank 2
        TextView scoreNameTwo = findViewById(R.id.score_name_2);
        scoreNameTwo.setText((leaderboard.getScore(1) != null)
                ? leaderboard.getScore(1).getName()
                : "More Attempts Needed");
        TextView scoreScoreTwo = findViewById(R.id.score_score_2);
        scoreScoreTwo.setText((leaderboard.getScore(1) != null)
                ? "" + leaderboard.getScore(1).getScore()
                : "More Attempts Needed");
        TextView scoreDateTwo = findViewById(R.id.score_date_2);
        scoreDateTwo.setText((leaderboard.getScore(1) != null)
                ? leaderboard.getScore(1).getTime()
                : "More Attempts Needed");
        // Rank 3
        TextView scoreNameThree = findViewById(R.id.score_name_3);
        scoreNameThree.setText((leaderboard.getScore(2) != null)
                ? leaderboard.getScore(2).getName()
                : "More Attempts Needed");
        TextView scoreScoreThree = findViewById(R.id.score_score_3);
        scoreScoreThree.setText((leaderboard.getScore(2) != null)
                ? "" + leaderboard.getScore(2).getScore()
                : "More Attempts Needed");
        TextView scoreDateThree = findViewById(R.id.score_date_3);
        scoreDateThree.setText((leaderboard.getScore(2) != null)
                ? leaderboard.getScore(2).getTime()
                : "More Attempts Needed");
        // Rank 4
        TextView scoreNameFour = findViewById(R.id.score_name_4);
        scoreNameFour.setText((leaderboard.getScore(3) != null)
                ? leaderboard.getScore(3).getName()
                : "More Attempts Needed");
        TextView scoreScoreFour = findViewById(R.id.score_score_4);
        scoreScoreFour.setText((leaderboard.getScore(3) != null)
                ? "" + leaderboard.getScore(3).getScore()
                : "More Attempts Needed");
        TextView scoreDateFour = findViewById(R.id.score_date_4);
        scoreDateFour.setText((leaderboard.getScore(3) != null)
                ? leaderboard.getScore(3).getTime()
                : "More Attempts Needed");
        // Rank 5
        TextView scoreNameFive = findViewById(R.id.score_name_5);
        scoreNameFive.setText((leaderboard.getScore(4) != null)
                ? leaderboard.getScore(4).getName()
                : "More Attempts Needed");
        TextView scoreScoreFive = findViewById(R.id.score_score_5);
        scoreScoreFive.setText((leaderboard.getScore(4) != null)
                ? "" + leaderboard.getScore(4).getScore()
                : "More Attempts Needed");
        TextView scoreDateFive = findViewById(R.id.score_date_5);
        scoreDateFive.setText((leaderboard.getScore(4) != null)
                ? leaderboard.getScore(4).getTime()
                : "More Attempts Needed");
    }

    private void restartGame() {
        Intent restartGame = new Intent(this, WelcomeScreen.class);
        startActivity(restartGame);
    }

}
