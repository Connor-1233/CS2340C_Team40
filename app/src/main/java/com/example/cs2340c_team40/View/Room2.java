package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

import java.util.ArrayList;

public class Room2 extends Activity {
    private Player player = Player.getInstance();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);

        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        entities.add(player);

        GameScreenViewModel.initializePlayer(640, 1415, entities);

        //        IterateView.checkA(room, player, this.getApplicationContext(), 2);
        EditText displayName = findViewById(R.id.display_player_name_text);
        EditText displayHealth = findViewById(R.id.display_health_text);
        TextView scoreTimerText = findViewById(R.id.score_text);

        displayName.setText(player.getName());
        String displayHealthString = "Health: " + player.getHealth();
        displayHealth.setText(displayHealthString);
        scoreTimerText.setText(String.valueOf(player.getScore()));
        ImageView spriteImageView = findViewById(R.id.spriteImageView);

        player.setSprite((ImageView) findViewById(R.id.sprite));

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

        Button restart = findViewById(R.id.NextRoom2);
        restart.setOnClickListener(v -> {
            Intent goRoom3 = new Intent(this, WelcomeScreen.class);
            startActivity(goRoom3);
        });
    }

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

        if (newY <= 1415 && newY >= 1320 && newX >= 625 && newX <= 645) { //entry way
            shouldMove = true;
        } else if (newY >= 1210 && newY <= 1320 && newX == 640) { //hallway
            shouldMove = true;
        } else if (newX >= 590 && newX <= 680 && newY <= 1210 && newY >= 975) { //room after hallway
            shouldMove = true;
        } else if (newX >= 650 && newX <= 680 && newY <= 975 && newY >= 860) { //passing door
            shouldMove = true;
        } else if (newX >= 200 && newX <= 685 && newY <= 860 && newY >= 525) { //big room
            shouldMove = true;
        }


        if (shouldMove) {
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
        }

        if (shouldMove) {
            player.update();
            if (player.getX() == 200 && player.getY() <= 715 && player.getY() >= 700) {
                Intent intent = new Intent(this, Room3.class);
                this.startActivity(intent);
            }
        }
        return true;
    }
}
