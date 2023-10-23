package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.view.MotionEvent;


import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Room;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

import java.util.ArrayList;


public class MapStartScreen extends Activity {
    private int counter;
    private Player player = Player.getInstance();
    private Room room;
//    private Handler movementHandler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room1);
        room = new Room(); //Need to fill room array

        //initiializing array for 30x30 grid
        for (int x = 0; x <= 29; x++) {
            for (int y = 0; y <= 29; y++) {
                room.addObject(x, y, 0);
            }
        }

        for (int x = 10; x <= 20; x++) {
            room.addObject(x, 12, 1);
            room.addObject(x, 19, 1);
        }
        for (int y = 13; y <= 18; y++) {
            room.addObject(10, y, 1);
            room.addObject(20, y, 1);
        }
        room.addObject(15, 19, 2); //door, exit

        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        entities.add(player);

        // i update start location to top door
        GameScreenViewModel.initializePlayer(200,15, room, entities);


        player.setSprite((ImageView) findViewById(R.id.sprite));
        EditText displayName = findViewById(R.id.display_player_name_text);
        EditText displayHealth = findViewById(R.id.display_health_text);
        displayName.setText(player.getName());
        String displayHealthString = "Health: " + player.getHealth();
        displayHealth.setText(displayHealthString);
        ImageView spriteImageView = findViewById(R.id.spriteImageView);

        if (player.getSpriteChoice() == 1) {
            spriteImageView.setImageResource(R.drawable.sprite1);
            player.getSprite().setImageResource(R.drawable.sprite1);
        } else if (player.getSpriteChoice() == 2) {
            spriteImageView.setImageResource(R.drawable.sprite2);
            player.getSprite().setImageResource(R.drawable.sprite2);
        } else {
            spriteImageView.setImageResource(R.drawable.sprite3);
            player.getSprite().setImageResource(R.drawable.sprite3);
        }

        TextView scoreTimerText = findViewById(R.id.score_text);
        counter = 30;
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                scoreTimerText.setText(String.valueOf(counter));
                counter--;
                player.setScore(counter);
            }
            public void onFinish() {
                scoreTimerText.setText(R.string.timerFinish);
            }
        }.start();

        Button endGameBtn = findViewById(R.id.go_end_screen_button);
        endGameBtn.setOnClickListener(v -> {
            Intent goEndScreen = new Intent(this, EndingScreen.class);
            startActivity(goEndScreen);
        });

        Button nextButton = findViewById(R.id.NextRoom1);
        nextButton.setOnClickListener(v -> {
            Intent goRoom2 = new Intent(this, Room2.class);
            startActivity(goRoom2);
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_W:
            player.setMoveDirection(new MoveVertical(-1));
            break;
        case KeyEvent.KEYCODE_S:
            player.setMoveDirection(new MoveVertical(1));
            break;
        case KeyEvent.KEYCODE_A:
            player.setMoveDirection(new MoveHorizontal(-1));
            break;
        case KeyEvent.KEYCODE_D:
            player.setMoveDirection(new MoveHorizontal(1));
            break;
        default:
            return super.onKeyDown(keyCode, event);
        }
        player.update();
        return true;
    }
}