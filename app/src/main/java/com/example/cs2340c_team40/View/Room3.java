package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.cs2340c_team40.Model.Leaderboard;
//import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

public class Room3 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room3);

        Player player = Player.getInstance();
        GameScreenViewModel.initializePlayer();

        EditText displayName = findViewById(R.id.display_player_name_text);
        EditText displayHealth = findViewById(R.id.display_health_text);
        TextView scoreTimerText = findViewById(R.id.score_text);

        displayName.setText(player.getName());
        String displayHealthString = "Health: " + player.getHealth();
        displayHealth.setText(displayHealthString);
        scoreTimerText.setText(String.valueOf(player.getScore()));

        ImageView spriteImageView = findViewById(R.id.spriteImageView);

        if (player.getSpriteChoice() == 1) {
            spriteImageView.setImageResource(R.drawable.bluepiskel);
        } else if (player.getSpriteChoice() == 2) {
            spriteImageView.setImageResource(R.drawable.greenpiskel);
        } else {
            spriteImageView.setImageResource(R.drawable.redpiskel);
        }

        /*
        Button nextButton = findViewById(R.id.NextRoom3);
        nextButton.setOnClickListener(v -> {
            Intent endGame = new Intent(this, EndingScreen.class);
            startActivity(endGame);
        });
         */
    }
}
