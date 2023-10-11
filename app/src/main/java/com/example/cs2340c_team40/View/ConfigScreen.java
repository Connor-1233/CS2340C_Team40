package com.example.cs2340c_team40.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.ConfigScreenViewModel;

public class ConfigScreen extends Activity {
    protected double difficulty = -1.0;
    protected String username = null;
    protected int spriteChoice = -1;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configscreen);

        Button proceedButton = findViewById(R.id.proceedButton);
        Button exitButton = findViewById(R.id.exitButton);
        RadioGroup difficultyRadioGroup = findViewById(R.id.RadioGroupDifficulty);
        RadioGroup characterChoice = findViewById(R.id.CostumeChoice);
        EditText characterName = findViewById(R.id.username);

        difficultyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio_easy) {
                    Toast.makeText(ConfigScreen.this, "Difficulty: easy",
                            Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radio_medium) {
                    Toast.makeText(ConfigScreen.this, "Difficulty: medium",
                            Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radio_hard) {
                    Toast.makeText(ConfigScreen.this, "Difficulty: hard",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ConfigScreen.this, "Difficulty: easy",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        characterChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio_costume_1) {
                    Toast.makeText(ConfigScreen.this, "You chose Sprite 1",
                            Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radio_costume_2) {
                    Toast.makeText(ConfigScreen.this, "You chose Sprite 2",
                            Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radio_costume_3) {
                    Toast.makeText(ConfigScreen.this, "You chose Sprite 3",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ConfigScreen.this, "You chose Sprite 1",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        exitButton.setOnClickListener(v -> finish());

        proceedButton.setOnClickListener(v -> {
            if (difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radio_easy) {
                difficulty = 0.5;
            } else if (difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radio_medium) {
                difficulty = 0.75;
            } else if (difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radio_hard) {
                difficulty = 1.0;
            } else {
                difficulty = 0.5;
            }

            if (characterChoice.getCheckedRadioButtonId() == R.id.radio_costume_1) {
                spriteChoice = 1;
            } else if (characterChoice.getCheckedRadioButtonId() == R.id.radio_costume_2) {
                spriteChoice = 2;
            } else if (characterChoice.getCheckedRadioButtonId() == R.id.radio_costume_3) {
                spriteChoice = 3;
            } else {
                spriteChoice = 1;
            }

            username = characterName.getText().toString();

            if (difficulty != -1.0 && spriteChoice != -1
                    && ConfigScreenViewModel.isValidName(username)) {
                proceedToGame();
            }
        });
    }

    //TODO Implement the above proceedButton.setOnClickListener in this method!
    public void onRadioButtonClicked(View view) {
    }
    private void proceedToGame() {
        // if all the methods return true, then proceed to Game Screen
        Intent startGame = new Intent(this, MapStartScreen.class);
        startGame.putExtra("difficulty", difficulty);
        startGame.putExtra("username", username);
        startGame.putExtra("spriteChoice", spriteChoice);
        startActivity(startGame);
    }
}
