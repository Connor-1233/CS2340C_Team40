package com.example.cs2340c_team40.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cs2340c_team40.R;

public class EndingScreen extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);

        Button restartGameBtn = findViewById(R.id.restart_game_btn);
        restartGameBtn.setOnClickListener(v -> restartGame());
    }

    /** This method "changes activity" to the config screen.
     * Essentially, when startGame() is called, the screen shifts the ConfigScreen
     * and whatever implementation in that class.
     */
    private void restartGame() {
        Intent restartGame = new Intent(this, WelcomeScreen.class);
        startActivity(restartGame);
    }
}
