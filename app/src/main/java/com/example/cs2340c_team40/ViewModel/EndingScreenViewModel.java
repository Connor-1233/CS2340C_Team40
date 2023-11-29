package com.example.cs2340c_team40.ViewModel;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.View.WelcomeScreen;

import java.util.Timer;

public class EndingScreenViewModel {
    public static void handleRestartButtonClick(Activity activity) {
        Button restart = activity.findViewById(R.id.restart_game_btn);
        restart.setOnClickListener(v -> {
            Intent goRoom3 = new Intent(activity, WelcomeScreen.class);
            activity.startActivity(goRoom3);
        });
    }

    public static int setFinalScore(int score, int health) {
        if (score < 0) {
            return 0;
        }
        return score + (health / 2);
    }
    public static void mapScoreToScreen(Activity activity, int score) {
        TextView gameScore = activity.findViewById(R.id.Score);
        gameScore.setText("Most Recent Score: " + score);
    }
}
