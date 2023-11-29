package com.example.cs2340c_team40.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.EndingScreenViewModel;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

public class EndingScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);

        //sets end screen to win or lose depending on whether health <= 0
        setVisibilityEndingScreen();

        EndingScreenViewModel.handleRestartButtonClick(this);

        Player player = Player.getInstance();
        Leaderboard leaderboard = Leaderboard.getInstance();

        //Evaluates Score based on current score and a percentage of health
        //Then calls the view model to render the score on the xml file
        player.setScore(EndingScreenViewModel.setFinalScore(player.getScore(), player.getHealth()));
        EndingScreenViewModel.mapScoreToScreen(this, player.getScore());

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

    /**
     * Public method that determines which ending screen is displayed,
     * based on whether the player has died or not.
     *
     * Default @+id/win_lable is visible and only becomes invisible when
     * player has died. If player dies, then @+id/lose_lable becomes visible.
     */
    public void setVisibilityEndingScreen() {
        if (GameScreenViewModel.isPlayerDead()) { //Player has died so change visibilities
            TextView winLable = findViewById(R.id.win_lable);
            TextView loseLable = findViewById(R.id.lose_lable);

            winLable.setVisibility(View.INVISIBLE);
            loseLable.setVisibility(View.VISIBLE);

            RatingBar winBar = findViewById(R.id.ratingBarWin);
            RatingBar loseBar = findViewById(R.id.ratingBarLose);

            winBar.setVisibility(RatingBar.INVISIBLE);
            loseBar.setVisibility(RatingBar.VISIBLE);

        }
        //Do Nothing because player isn't dead
    }

}
