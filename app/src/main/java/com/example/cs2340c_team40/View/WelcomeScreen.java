package com.example.cs2340c_team40.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.WelcomeScreenViewModel;
//import com.example.cs2340c_team40.ViewModel.WelcomeScreenViewModel;

public class WelcomeScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomescreen);

        WelcomeScreenViewModel.handleStartButton(this);
        WelcomeScreenViewModel.handleExitButton(this);
    }
}

