package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Room;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;
import com.example.cs2340c_team40.ViewModel.WelcomeScreenViewModel;

import java.util.ArrayList;

public class Room3 extends Activity {
    private Player player = Player.getInstance();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room3);

        Room room = new Room(); //Need to fill room array

        //initiializing array for 30x30 grid
//        for (int x = 0; x <= 29; x++) {
//            for (int y = 0; y <= 29; y++) {
//                room.addObject(x, y, 0);
//            }
//        }
//
//        for (int y = 6; y <= 16; y++) {
//            room.addObject(7, y, 1);
//        }
//        for (int x = 8; x <= 19; x++) {
//            room.addObject(x, 6, 1);
//        }
//        for (int x = 8; x <= 10; x++) {
//            room.addObject(x, 16, 1);
//        }
//        for (int y = 17; y <= 25; y++) {
//            room.addObject(10, y, 1);
//        }
//        for (int x = 11; x <= 16; x++) {
//            room.addObject(x, 25, 1);
//        }
//        for (int y = 16; y <= 24; y++) {
//            room.addObject(16, y, 1);
//        }
//        for (int x = 17; x <= 19; x++) {
//            room.addObject(x, 16, 1);
//        }
//        for (int y = 13; y <= 15; y++) {
//            room.addObject(19, y, 1);
//        }
//        for (int y = 7; y <= 9; y++) {
//            room.addObject(19, y, 1);
//        }
//        for (int x = 20; x <= 26; x++) {
//            room.addObject(x, 10, 1);
//            room.addObject(x, 12, 1);
//        }
//
//        //the water :///
//        for (int x = 10; x <= 12; x++) {
//            for (int y = 10; y <= 12; y++) {
//                room.addObject(x, y, 1);
//            }
//        }
//        for (int x = 15; x <= 17; x++) {
//            for (int y = 10; y <= 12; y++) {
//                room.addObject(x, y, 1);
//            }
//        }
//        for (int x = 12; x <= 14; x++) {
//            room.addObject(x, 20, 1);
//        }
//
//        room.addObject(26, 11, 2); //the door, exit

//
//        for (int x = 0; x < 31; x++) {
//            for (int y = 0; y < 31; y++) {
//                if (room.checkLocation(x, y) != 1) {
//                    room.addObject(x, y, 0);
//                }
//            }
//        }

        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        entities.add(player);

        //have to change x and y to where door is in each map
        GameScreenViewModel.initializePlayer(460, 1550, room, entities);

        EditText displayName = findViewById(R.id.display_player_name_text);
        EditText displayHealth = findViewById(R.id.display_health_text);
        TextView scoreTimerText = findViewById(R.id.score_text);

        player.setSprite((ImageView) findViewById(R.id.sprite));
        displayName.setText(player.getName());
        String displayHealthString = "Health: " + player.getHealth();
        displayHealth.setText(displayHealthString);
        scoreTimerText.setText(String.valueOf(player.getScore()));
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

//        if (room.checkLocation(player.getX(), player.getY()) == 2) {
//            //if door
//            Intent endGame = new Intent(this, EndingScreen.class);
//            startActivity(endGame);
//        }


        Button restart = findViewById(R.id.NextRoom3);
        restart.setOnClickListener(v -> {
            Intent endGame = new Intent(this, WelcomeScreen.class);
            startActivity(endGame);
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        int newX = player.getX();
        int newY = player.getY();

        switch (keyCode) {
        case KeyEvent.KEYCODE_W:
            newY = newY - 5;
            break;
        case KeyEvent.KEYCODE_S:
            newY = newY + 5;
            break;
        case KeyEvent.KEYCODE_A:
            newX = newX - 5;
            break;
        case KeyEvent.KEYCODE_D:
            newX = newX + 5;
            break;
        default:
            break;
        }
        boolean shouldMove = false;

        if (newY <= 1550 && newY >= 980 && newX >= 375 && newX <= 545) { //first room
            shouldMove = true;
        } else if (newY >= 925 && newY <= 980 && newX >= 400 && newX <= 525) { //hallway
            shouldMove = true;
        } else if (newX >= 265 && newX <= 645 && newY <= 925 && newY >= 325) { //bigRoom
            shouldMove = true;
        } else if (newX >= 640 && newX <= 925 && newY <= 640 && newY >= 595) { //passing door
            shouldMove = true;
        }

        Log.d("position",  "x: " + player.getX() + " y: " + player.getY());

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

        if (shouldMove) {
            player.update();
            if (player.getX() == 925 && player.getY() <= 640 && player.getY() >= 595) {
                Intent intent = new Intent(this, EndingScreen.class);
                this.startActivity(intent);
            }
        }
        return true;
    }

}
