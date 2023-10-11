package com.example.cs2340c_team40.ViewModels;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.R;
import com.google.android.material.navigation.NavigationView;

public class EndingScreen extends AppCompatActivity {
    LeaderboardAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endingscreen);
        Leaderboard leaderboard = Leaderboard.getInstance();

        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LeaderboardAdapter(getApplicationContext()));
    }
}
