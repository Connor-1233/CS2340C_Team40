package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340c_team40.R;

public class MapStartScreen extends AppCompatActivity {
    protected int health;
    protected int counter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room1);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        double difficultyGame = intent.getDoubleExtra("difficulty", 0.5);
        int spriteChoice = intent.getIntExtra("spriteChoice", 1);

        if (difficultyGame == .5) {
            health = 150;
        } else if (difficultyGame == .75) {
            health = 100;
        } else {
            health = 50;
        }

        EditText displayName = findViewById(R.id.display_player_name_text);
        EditText displayHealth = findViewById(R.id.display_health_text);
        displayName.setText(name);
        String displayHealthString = "Health: " + health;
        displayHealth.setText(displayHealthString);

        ImageView spriteImageView = findViewById(R.id.spriteImageView);

        if (spriteChoice == 1) {
            spriteImageView.setImageResource(R.drawable.bluepiskel);
        } else if (spriteChoice == 2) {
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
            }
            public  void onFinish() {
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