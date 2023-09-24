package com.example.cs2340c_team40;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MapStartScreen extends AppCompatActivity {
    protected int health;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapstartscreen);

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
            spriteImageView.setImageResource(R.drawable.bluePiskel);
        } else if (spriteChoice == 2) {
            spriteImageView.setImageResource(R.drawable.greenPiskel);
        } else {
            spriteImageView.setImageResource(R.drawable.redPiskel);
        }

        Button endGameBtn = findViewById(R.id.go_end_screen_button);
        endGameBtn.setOnClickListener(v -> {
            Intent goEndScreen = new Intent(this, EndingScreen.class);
            startActivity(goEndScreen);
        });
    }
}