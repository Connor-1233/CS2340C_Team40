package com.example.cs2340c_team40.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
//import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Player;
//import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.LeaderboardAdapter;

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
        //leaderboard.updateScore(player.getScore(), player.getName());

<<<<<<< HEAD
        // Leaderboard
        // Rank 1
        TextView score_name_1 = findViewById(R.id.score_name_1);
        score_name_1.setText((leaderboard.getScore(0) != null)
                                ? leaderboard.getScore(0).getName()
                                : "More Attempts Needed");
        TextView score_score_1 = findViewById(R.id.score_score_1);
        score_score_1.setText((leaderboard.getScore(0) != null)
                                ? "" + leaderboard.getScore(0).getScore()
                                : "More Attempts Needed");
        TextView score_date_1 = findViewById(R.id.score_date_1);
        score_date_1.setText((leaderboard.getScore(0) != null)
                                ? leaderboard.getScore(0).getTime()
                                : "More Attempts Needed");
        // Rank 2
        TextView score_name_2 = findViewById(R.id.score_name_2);
        score_name_2.setText((leaderboard.getScore(1) != null)
                ? leaderboard.getScore(1).getName()
                : "More Attempts Needed");
        TextView score_score_2 = findViewById(R.id.score_score_2);
        score_score_2.setText((leaderboard.getScore(1) != null)
                ? "" + leaderboard.getScore(1).getScore()
                : "More Attempts Needed");
        TextView score_date_2 = findViewById(R.id.score_date_2);
        score_date_2.setText((leaderboard.getScore(1) != null)
                ? leaderboard.getScore(1).getTime()
                : "More Attempts Needed");
        // Rank 3
        TextView score_name_3 = findViewById(R.id.score_name_3);
        score_name_3.setText((leaderboard.getScore(2) != null)
                ? leaderboard.getScore(2).getName()
                : "More Attempts Needed");
        TextView score_score_3 = findViewById(R.id.score_score_3);
        score_score_3.setText((leaderboard.getScore(2) != null)
                ? "" + leaderboard.getScore(2).getScore()
                : "More Attempts Needed");
        TextView score_date_3 = findViewById(R.id.score_date_3);
        score_date_3.setText((leaderboard.getScore(2) != null)
                ? leaderboard.getScore(2).getTime()
                : "More Attempts Needed");
        // Rank 4
        TextView score_name_4 = findViewById(R.id.score_name_4);
        score_name_4.setText((leaderboard.getScore(3) != null)
                ? leaderboard.getScore(3).getName()
                : "More Attempts Needed");
        TextView score_score_4 = findViewById(R.id.score_score_4);
        score_score_4.setText((leaderboard.getScore(3) != null)
                ? "" + leaderboard.getScore(3).getScore()
                : "More Attempts Needed");
        TextView score_date_4 = findViewById(R.id.score_date_4);
        score_date_4.setText((leaderboard.getScore(3) != null)
                ? leaderboard.getScore(3).getTime()
                : "More Attempts Needed");
        // Rank 5
        TextView score_name_5 = findViewById(R.id.score_name_5);
        score_name_5.setText((leaderboard.getScore(4) != null)
                ? leaderboard.getScore(4).getName()
                : "More Attempts Needed");
        TextView score_score_5 = findViewById(R.id.score_score_5);
        score_score_5.setText((leaderboard.getScore(4) != null)
                ? "" + leaderboard.getScore(4).getScore()
                : "More Attempts Needed");
        TextView score_date_5 = findViewById(R.id.score_date_5);
        score_date_5.setText((leaderboard.getScore(4) != null)
                ? leaderboard.getScore(4).getTime()
                : "More Attempts Needed");
//        RecyclerView recyclerView = findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new LeaderboardAdapter(getApplicationContext()));
//=======
//        RecyclerView recyclerView = findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new LeaderboardAdapter());
//>>>>>>> 0f6a4c5a68620369b14dbdc462df0d4be1ed4750
    }

    private void restartGame() {
        Intent restartGame = new Intent(this, WelcomeScreen.class);
        startActivity(restartGame);
    }

}
