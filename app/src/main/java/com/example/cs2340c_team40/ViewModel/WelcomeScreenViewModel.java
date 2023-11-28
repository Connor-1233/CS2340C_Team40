package com.example.cs2340c_team40.ViewModel;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import androidx.lifecycle.ViewModel;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.View.ConfigScreen;

public class WelcomeScreenViewModel extends ViewModel {

    public static void handleStartButton(Activity activity) {
        Button startButton = activity.findViewById(R.id.startButton);
        startButton.setOnClickListener(v -> {
            Intent goConfigScreen = new Intent(activity, ConfigScreen.class);
            activity.startActivity(goConfigScreen);
        });
    }

    public static void handleExitButton(Activity activity) {
        Button exitButton = activity.findViewById(R.id.exitButton);
        exitButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);
        });
    }
}
