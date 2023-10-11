package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

import com.example.cs2340c_team40.R;

public class Room2 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);

        Button nextButton = findViewById(R.id.NextRoom2);
        nextButton.setOnClickListener(v -> {
            Intent goRoom3 = new Intent(this, Room3.class);
            startActivity(goRoom3);
        });
    }
}
