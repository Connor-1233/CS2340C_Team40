package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Enemy;
import com.example.cs2340c_team40.Model.EnemyFactory;
import com.example.cs2340c_team40.Model.HealthPowerUpDecorator;
import com.example.cs2340c_team40.Model.MovePattern;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.PlayerDirection;
import com.example.cs2340c_team40.Model.PowerUp;
import com.example.cs2340c_team40.Model.PowerUpItem;
import com.example.cs2340c_team40.Model.DamagePowerUpDecorator;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.Model.Weapon;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Room3 extends Activity {
    private int counter;
    private final Player player = Player.getInstance();
    private Weapon weapon = Weapon.getInstance();
    private Timer moveTimer;
    private ArrayList<Subscriber> entities;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room3);

        entities = new ArrayList<Subscriber>();
        entities.add(player);
        EnemyFactory enemyCreator = new EnemyFactory();
        //Ghost Enemy
        Enemy ghost = enemyCreator.createEnemy("Ghost");
        ghost.setX(300);
        ghost.setY(865);

        int[] ghostArray = {215, 230, 215, 230};

        ghost.setSprite((ImageView) findViewById(R.id.ghost));
        ghost.getSprite().setImageResource(R.drawable.skull_v1_2);


        PlayerDirection ghostPattern = new MovePattern(ghost, ghostArray, 'w');
        ghost.setMoveDirection(ghostPattern);
        entities.add(ghost);



        //Knight Enemy
        Enemy knight = enemyCreator.createEnemy("Knight");
        knight.setX(600);
        knight.setY(870);

        int[] knightArray = {480, 100, 480, 100};

        knight.setSprite((ImageView) findViewById(R.id.knight));
        knight.getSprite().setImageResource(R.drawable.vampire_v2_2);


        PlayerDirection knightPattern = new MovePattern(knight, knightArray, 'a');
        knight.setMoveDirection(knightPattern);
        entities.add(knight);

        //have to change x and y to where door is in each map
        GameScreenViewModel.initializePlayer(460, 1550, entities);
        player.getEnemyList().add(ghost);
        player.getEnemyList().add(knight);
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
                            //EditText displayName = findViewById(R.id.display_player_name_text);
                            //EditText displayHealth = findViewById(R.id.display_health_text);
                            //displayName.setText(player.getName());
                            //String displayHealthString = "Health: " + player.getHealth();
                            //displayHealth.setText(displayHealthString);
                            //ImageView spriteImageView = findViewById(R.id.spriteImageView);

                        }
                    }
                });
            }

        }, 0, 50);

        //        EditText displayName = findViewById(R.id.display_player_name_text);
        //        EditText displayHealth = findViewById(R.id.display_health_text);
        //displayName.setText(player.getName());
        //String displayHealthString = "Health: " + player.getHealth();
        //displayHealth.setText(displayHealthString);
        //.setText(String.valueOf(player.getScore()));

        TextView scoreTimerText = findViewById(R.id.score_text);
        player.setSprite((ImageView) findViewById(R.id.sprite));

        counter = player.getScore();
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (counter >= 0) {
                    if (counter != 0) {
                        counter--;
                    }
                    scoreTimerText.setText(String.valueOf(counter));
                    player.setScore(counter);
                    EditText displayName = findViewById(R.id.display_player_name_text);
                    EditText displayHealth = findViewById(R.id.display_health_text);
                    displayName.setText(player.getName());
                    String displayHealthString = "Health: " + player.getHealth();
                    displayHealth.setText(displayHealthString);
                }
            }
            public void onFinish() {
                scoreTimerText.setText(R.string.timerFinish);
            }
        }.start();

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

        Button restart = findViewById(R.id.NextRoom3);
        restart.setOnClickListener(v -> {
            moveTimer.cancel();
            Intent endGame = new Intent(this, WelcomeScreen.class);
            startActivity(endGame);
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int[] coords = GameScreenViewModel.getNewCoordinates(keyCode, player.getX(), player.getY());
        boolean shouldMove = GameScreenViewModel.shouldPlayerMove(Room3.class, coords[0], coords[1]);
        boolean[] hitPowerUpArray = GameScreenViewModel.hasHitPowerUp(Room3.class, coords[0], coords[1]);

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
            case KeyEvent.KEYCODE_L:
                weapon.notifyEnemies();
                updateEnemyList();
                break;
            default:
                return super.onKeyDown(keyCode, event);
            }
        }

        if (hitPowerUpArray[0]) { //we've hit the bottom power-up
            ImageView damagePowerUp = findViewById(R.id.damage_powerup);
            damagePowerUp.setVisibility(View.INVISIBLE);
            PowerUp p = new DamagePowerUpDecorator(new PowerUpItem(), player);
            p.updatePowerUpEffect();
            hitPowerUpArray[0] = false;
        } else if (hitPowerUpArray[1]) { //we've hit the top power-up
            ImageView healthPowerUp = findViewById(R.id.health_powerup);
            healthPowerUp.setVisibility(View.INVISIBLE);
            PowerUp p = new HealthPowerUpDecorator(new PowerUpItem(), player);
            p.updatePowerUpEffect();
            hitPowerUpArray[1] = false;
            //probably implement the power-up functionality here
        }

        //Log.d("Room3 Position",  "x: " + player.getX() + " y: " + player.getY());
        if (shouldMove) {
            if (player.getX() == 925 && player.getY() <= 640 && player.getY() >= 595) {
                Intent intent = new Intent(this, EndingScreen.class);
                moveTimer.cancel();
                this.startActivity(intent);
            }
        }
        return true;
    }

    public void checkHealth() {
        if (GameScreenViewModel.isPlayerDead()) {
            launchGameLoseScreen();
        }
    }
    public void updateEnemyList() {
        ArrayList<Subscriber> removedEnemies = new ArrayList<>();
        for (Subscriber e: entities){
            if (e instanceof Enemy) {
                Enemy enemy = (Enemy) e;
                if (enemy.isEnemyDestroyed()) {
                    removedEnemies.add((Subscriber) e);
                }
            }
        }
        for (Subscriber removed : removedEnemies) {
            entities.remove(removed);
        }
    }
    public void launchGameLoseScreen() {
        moveTimer.cancel();
        Intent intent = new Intent(this, EndingScreen.class);
        startActivity(intent);
    }

}
