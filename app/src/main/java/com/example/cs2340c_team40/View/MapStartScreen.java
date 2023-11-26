package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;


import com.example.cs2340c_team40.Model.Enemy;
import com.example.cs2340c_team40.Model.EnemyFactory;
import com.example.cs2340c_team40.Model.MovePattern;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.PlayerDirection;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MapStartScreen extends Activity {
    private int counter;
    private Timer moveTimer;
    private final Player player = Player.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room1);

        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        entities.add(player);
        EnemyFactory enemyCreator = new EnemyFactory();
        //Ghost Enemy
        Enemy ghost = enemyCreator.createEnemy("Ghost");
        ghost.setX(660);
        ghost.setY(860);

        int[] ghostArray = {0, 230, 0, 230};


        ghost.setSprite((ImageView) findViewById(R.id.ghost));
        ghost.getSprite().setImageResource(R.drawable.skull_v1_2);

        PlayerDirection ghostPattern = new MovePattern(ghost, ghostArray, 'a');
        ghost.setMoveDirection(ghostPattern);
        entities.add(ghost);


        //Knight Enemy
        Enemy knight = enemyCreator.createEnemy("Knight");
        knight.setX(430);
        knight.setY(730);

        int[] knightArray = {0, 230, 0, 230};


        knight.setSprite((ImageView) findViewById(R.id.knight));
        knight.getSprite().setImageResource(R.drawable.vampire_v2_2);
      
        PlayerDirection knightPattern = new MovePattern(knight, knightArray, 'd');
        knight.setMoveDirection(knightPattern);
        entities.add(knight);
        player.getEnemyList().add(knight);
        player.getEnemyList().add(ghost);


        // i update start location to top door
        GameScreenViewModel.initializePlayer(530, 1000, entities);
        moveTimer = new Timer();
        moveTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (Subscriber subscriber : entities) {
                            checkHealth();
                            subscriber.update();
                        }
                    }
                });
            }

        }, 0, 50);


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
            player.setPixelHeight(spriteImageView.getHeight());
            player.setPixelWidth(spriteImageView.getWidth());
        } else if (player.getSpriteChoice() == 2) {
            spriteImageView.setImageResource(R.drawable.sprite2);
            player.getSprite().setImageResource(R.drawable.sprite2);
            player.setPixelHeight(spriteImageView.getHeight());
            player.setPixelWidth(spriteImageView.getWidth());
        } else {
            spriteImageView.setImageResource(R.drawable.sprite3);
            player.getSprite().setImageResource(R.drawable.sprite3);
            player.setPixelHeight(spriteImageView.getHeight());
            player.setPixelWidth(spriteImageView.getWidth());
        }

        TextView scoreTimerText = findViewById(R.id.score_text);
        counter = 30;
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                scoreTimerText.setText(String.valueOf(counter));
                counter--;
                player.setScore(counter);
                //EditText displayName = findViewById(R.id.display_player_name_text);
                EditText displayHealth = findViewById(R.id.display_health_text);
                //displayName.setText(player.getName());
                String displayHealthString = "Health: " + player.getHealth();
                displayHealth.setText(displayHealthString);
            }
            public void onFinish() {
                scoreTimerText.setText(R.string.timerFinish);
            }
        }.start();

        Button endGameBtn = findViewById(R.id.go_end_screen_button);
        endGameBtn.setOnClickListener(v -> {
            moveTimer.cancel();
            Intent goEndScreen = new Intent(this, EndingScreen.class);
            startActivity(goEndScreen);
        });

        Button restart = findViewById(R.id.NextRoom1);
        restart.setOnClickListener(v -> {
            moveTimer.cancel();
            Intent goRoom2 = new Intent(this, WelcomeScreen.class);
            startActivity(goRoom2);
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int[] coords = GameScreenViewModel.getNewCoordinates(keyCode, player.getX(), player.getY());
        boolean shouldMove = GameScreenViewModel.shouldPlayerMove(Room1.class, coords[0], coords[1]);

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
            if (player.getX() == 530 && player.getY() == 605) {
                Intent intent = new Intent(this, Room2.class);
                moveTimer.cancel();
                this.startActivity(intent);
            }
        }
        return true;
    }


    public void checkHealth() {
        if (GameScreenViewModel.isPlayerDead()) {
            //            runOnUiThread(new Runnable() {
            //                @Override
            //                public void run() {
            //                    launchGameLoseScreen();
            //                }
            //            });
            launchGameLoseScreen();
        }
    }

    public void launchGameLoseScreen() {
        Intent intent = new Intent(this, EndingScreen.class);
        startActivity(intent);
    }
}