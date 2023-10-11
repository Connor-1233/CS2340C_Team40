package com.example.cs2340c_team40.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.R;

public class EndingScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);
        Button restartGameBtn = findViewById(R.id.restart_game_btn);
        restartGameBtn.setOnClickListener(v -> restartGame());
//        configureLeaderboard();
    }

    private void restartGame() {
        Intent restartGame = new Intent(this, WelcomeScreen.class);
        startActivity(restartGame);
    }

//    protected void configureLeaderboard() {
//        LinearLayout board = findViewById(R.id.LinearView);
//        Leaderboard leaderboard = Leaderboard.getInstance();
//
//        int counter = 0;
//        int stop = (Leaderboard.rankings.size() < 5) ? Leaderboard.rankings.size() : 5;
//        while (counter < stop) {
//            if (counter == 0) {
//                Score score_1_board = leaderboard.getScore(0);
//                TextView name_1 = findViewById(R.id.Name_HighScore_1);
//                TextView score_1 = findViewById(R.id.Score_HighScore_1);
//                TextView date_1 = findViewById(R.id.Date_HighScore_1);
//                name_1.setText(score_1_board.getName());
//                score_1.setText(score_1_board.getScore());
//                date_1.setText(score_1_board.getTime());
//            } else if (counter == 1) {
//                Score score_2_board = leaderboard.getScore(1);
//                TextView name_2 = findViewById(R.id.Name_HighScore_2);
//                TextView score_2 = findViewById(R.id.Score_HighScore_2);
//                TextView date_2 = findViewById(R.id.Date_HighScore_2);
//                name_2.setText(score_2_board.getName());
//                score_2.setText(score_2_board.getScore());
//                date_2.setText(score_2_board.getTime());
//            } else if (counter == 2) {
//                Score score_3_board = leaderboard.getScore(2);
//                TextView name_3 = findViewById(R.id.Name_HighScore_3);
//                TextView score_3 = findViewById(R.id.Score_HighScore_3);
//                TextView date_3 = findViewById(R.id.Date_HighScore_3);
//                name_3.setText(score_3_board.getName());
//                score_3.setText(score_3_board.getScore());
//                date_3.setText(score_3_board.getTime());
//            } else if (counter == 3) {
//                Score score_4_board = leaderboard.getScore(3);
//                TextView name_4 = findViewById(R.id.Name_HighScore_4);
//                TextView score_4 = findViewById(R.id.Score_HighScore_4);
//                TextView date_4 = findViewById(R.id.Date_HighScore_4);
//                name_4.setText(score_4_board.getName());
//                score_4.setText(score_4_board.getScore());
//                date_4.setText(score_4_board.getTime());
//            } else {
//                Score score_5_board = leaderboard.getScore(4);
//                TextView name_5 = findViewById(R.id.Name_HighScore_5);
//                TextView score_5 = findViewById(R.id.Score_HighScore_5);
//                TextView date_5 = findViewById(R.id.Date_HighScore_5);
//                name_5.setText(score_5_board.getName());
//                score_5.setText(score_5_board.getScore());
//                date_5.setText(score_5_board.getTime());
//            }
//            counter++;
//        }
//    }
}
