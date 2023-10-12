package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.R;

public class Room3 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room3);

        Button nextButton = findViewById(R.id.NextRoom3);
        nextButton.setOnClickListener(v -> {
            Intent endGame = new Intent(this, EndingScreen.class);
            startActivity(endGame);
        });
    }
}
