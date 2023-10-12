package com.example.cs2340c_team40.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.LeaderboardAdapter;

public class EndingScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);
        Button restartGameBtn = findViewById(R.id.restart_game_btn);
        restartGameBtn.setOnClickListener(v -> restartGame());

        Player player = Player.getInstance();
        Leaderboard leaderboard = Leaderboard.getInstance();
        leaderboard.updateScore(player.getScore(), player.getName());

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LeaderboardAdapter(getApplicationContext()));
    }

    private void restartGame() {
        Intent restartGame = new Intent(this, WelcomeScreen.class);
        startActivity(restartGame);
    }

}
