package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;


public class MapStartScreen extends AppCompatActivity {
    protected int counter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room1);

        Player player = Player.getInstance();
        GameScreenViewModel.initializePlayer();

        EditText displayName = findViewById(R.id.display_player_name_text);
        EditText displayHealth = findViewById(R.id.display_health_text);
        displayName.setText(player.getName());
        String displayHealthString = "Health: " + player.getHealth();
        displayHealth.setText(displayHealthString);

        ImageView spriteImageView = findViewById(R.id.spriteImageView);

        if (player.getSpriteChoice() == 1) {
            spriteImageView.setImageResource(R.drawable.bluepiskel);
        } else if (player.getSpriteChoice() == 2) {
            spriteImageView.setImageResource(R.drawable.greenpiskel);
        } else {
            spriteImageView.setImageResource(R.drawable.redpiskel);
        }

        TextView scoreTimerText = findViewById(R.id.score_text);
        counter = 30;
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                scoreTimerText.setText(String.valueOf(counter));
                counter--;
                player.setScore(counter);
            }
            public void onFinish() {
                scoreTimerText.setText(R.string.timerFinish);
            }
        }.start();

        Button endGameBtn = findViewById(R.id.go_end_screen_button);
        endGameBtn.setOnClickListener(v -> {
            Intent goEndScreen = new Intent(this, EndingScreen.class);
            startActivity(goEndScreen);
        });

        Button nextButton = findViewById(R.id.NextRoom1);
        nextButton.setOnClickListener(v -> {
            Intent goRoom2 = new Intent(this, Room2.class);
            startActivity(goRoom2);
        });



    }
}