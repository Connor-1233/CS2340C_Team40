package com.example.cs2340c_team40;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
public class WelcomeScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomescreen);

        Button startButton = findViewById(R.id.startButton);
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(v -> startGame()); //this method must change
        exitButton.setOnClickListener(v -> finish());
    }

    /** This method "changes activity" to the config screen.
     * Essentially, when startGame() is called, the screen shifts the ConfigScreen
     * and whatever implementation in that class.
     */
    private void startGame() {
        Intent startGame = new Intent(this, ConfigScreen.class);
        startActivity(startGame);
    }
}