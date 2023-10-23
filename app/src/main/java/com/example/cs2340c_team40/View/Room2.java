package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
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

import java.util.ArrayList;

public class Room2 extends Activity {
    private Player player = Player.getInstance();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);

        Room room = new Room(); //Need to fill room array

        //initiializing array for 30x30 grid
        for (int x = 0; x <= 29; x++) {
            for (int y = 0; y <= 29; y++) {
                room.addObject(x, y, 0);
            }
        }
        for (int y = 9; y <= 15; y++) {
            room.addObject(5, y, 1);
        }
        for (int x = 6; x <= 20; x++) {
            room.addObject(x, 9, 1);
        }
        for (int y = 10; y <= 20; y++) {
            room.addObject(20, y, 1);
        }
        for (int x = 6; x <= 16; x++) {
            room.addObject(x, 15, 1);
        }
        for (int y = 16; y <= 20; y++) {
            room.addObject(16, y, 1);
        }
        for (int y = 20; y <= 23; y++) {
            room.addObject(17, y, 1);
            room.addObject(19, y, 1);
        }
        room.addObject(18, 23, 1);

        room.addObject(18, 23, 2); //door, exit



        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        entities.add(player);

        //change
        GameScreenViewModel.initializePlayer(6,12, room, entities);

        EditText displayName = findViewById(R.id.display_player_name_text);
        EditText displayHealth = findViewById(R.id.display_health_text);
        TextView scoreTimerText = findViewById(R.id.score_text);

        displayName.setText(player.getName());
        String displayHealthString = "Health: " + player.getHealth();
        displayHealth.setText(displayHealthString);
        scoreTimerText.setText(String.valueOf(player.getScore()));

        ImageView spriteImageView = findViewById(R.id.spriteImageView);

        if (player.getSpriteChoice() == 1) {
            spriteImageView.setImageResource(R.drawable.sprite1);
        } else if (player.getSpriteChoice() == 2) {
            spriteImageView.setImageResource(R.drawable.sprite2);
        } else {
            spriteImageView.setImageResource(R.drawable.sprite3);
        }

        Button nextButton = findViewById(R.id.NextRoom2);
        nextButton.setOnClickListener(v -> {
            Intent goRoom3 = new Intent(this, Room3.class);
            startActivity(goRoom3);
        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                player.setMoveDirection(new MoveVertical(-1));
                return true;
            case KeyEvent.KEYCODE_S:
                player.setMoveDirection(new MoveVertical(1));
                return true;
            case KeyEvent.KEYCODE_A:
                player.setMoveDirection(new MoveHorizontal(-1));
                return true;
            case KeyEvent.KEYCODE_D:
                player.setMoveDirection(new MoveHorizontal(1));
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }
    /* Touch Controls
    @Override
    public boolean onTouchEvent(MotionEvent e){
        if (e.getAction() == MotionEvent.ACTION_MOVE) {
            GameScreenViewModel.updateTouch(e.getX(), e.getY());
        }
        return true;
    }
    */
}
