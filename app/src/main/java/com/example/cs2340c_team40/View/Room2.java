package com.example.cs2340c_team40.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Enemy;
import com.example.cs2340c_team40.Model.EnemyFactory;
import com.example.cs2340c_team40.Model.MovePattern;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.PlayerDirection;
import com.example.cs2340c_team40.Model.PowerUp;
import com.example.cs2340c_team40.Model.PowerUpItem;
import com.example.cs2340c_team40.Model.ScorePowerUpDecorator;
import com.example.cs2340c_team40.Model.DamagePowerUpDecorator;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Room2 extends Activity {
    private final Player player = Player.getInstance();
    private int counter;
    private Timer moveTimer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);

        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        entities.add(player);
        EnemyFactory enemyCreator = new EnemyFactory();
        //Ghost Enemy
        Enemy ghost = enemyCreator.createEnemy("Ghost");
        ghost.setX(460);
        ghost.setY(820);
        int[] ghostArray = {0, 190, 0, 190};

        ghost.setSprite((ImageView) findViewById(R.id.ghost));
        ghost.getSprite().setImageResource(R.drawable.skull_v1_2);

        PlayerDirection ghostPattern = new MovePattern(ghost, ghostArray, 'd');
        ghost.setMoveDirection(ghostPattern);
        entities.add(ghost);



        //Knight Enemy
        Enemy knight = enemyCreator.createEnemy("Knight");
        knight.setX(260);
        knight.setY(830);
        int[] knightArray = {220, 0, 220, 0};

        knight.setSprite((ImageView) findViewById(R.id.knight));
        knight.getSprite().setImageResource(R.drawable.vampire_v2_2);

        PlayerDirection knightPattern = new MovePattern(knight, knightArray, 'w');
        knight.setMoveDirection(knightPattern);
        entities.add(knight);

        //Skeleton Enemy
        //        Enemy skeleton = enemyCreator.createEnemy("Skeleton");
        //        skeleton.setX(400);
        //        skeleton.setY(620);
        //
        //        int[] skeletonArray = {100, 200, 100, 200};
        //
        //        skeleton.setSprite((ImageView) findViewById(R.id.knight));
        //        skeleton.getSprite().setImageResource(R.drawable.skeleton_v1_1);
        //
        //        PlayerDirection skeletonPattern = new MovePattern(skeleton, skeletonArray, 'd');
        //        skeleton.setMoveDirection(skeletonPattern);
        //        entities.add(skeleton);

        EditText displayName = findViewById(R.id.display_player_name_text);
        displayName.setText(player.getName());

        //Log.d("Health", "Health of Player is: " + player.getHealth());

        GameScreenViewModel.initializePlayer(640, 1415, entities);
        player.getEnemyList().add(knight);
        player.getEnemyList().add(ghost);
        moveTimer = new Timer();
        moveTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Subscriber subscriber : entities) {
                    checkHealth();
                    subscriber.update();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        EditText displayHealth = findViewById(R.id.display_health_text);
                        String displayHealthString = "Health: " + player.getHealth();
                        displayHealth.setText(displayHealthString);
                    }
                });
            }

        }, 0, 50);

        TextView scoreTimerText = findViewById(R.id.score_text);
        counter = player.getScore();
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (counter >= 0) {
                    if (counter != 0) {
                        counter--;
                    }
                    scoreTimerText.setText(String.valueOf(counter));
                    player.setScore(counter);
                }

            }
            public void onFinish() {
                scoreTimerText.setText(R.string.timerFinish);
            }
        }.start();

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
            moveTimer.cancel();
            startActivity(goRoom3);
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int[] coords = GameScreenViewModel.getNewCoordinates(keyCode, player.getX(), player.getY());
        boolean shouldMove = GameScreenViewModel.shouldPlayerMove(Room2.class, coords[0], coords[1]);
        boolean[] hitPowerUpArray = GameScreenViewModel.hasHitPowerUp(Room2.class, coords[0], coords[1]);

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

        if (hitPowerUpArray[0]) { //we've hit the bottom power-up
            ImageView scorePowerUp = findViewById(R.id.score_powerup);
            scorePowerUp.setVisibility(View.INVISIBLE);
            PowerUp p = new ScorePowerUpDecorator(new PowerUpItem(), player);
            p.updatePowerUpEffect();
            hitPowerUpArray[0] = false;
            //probably implement the power-up functionality here
        } else if (hitPowerUpArray[1]) { //we've hit the top power-up
            ImageView damagePowerUp = findViewById(R.id.damage_powerup);
            damagePowerUp.setVisibility(View.INVISIBLE);
            PowerUp p = new DamagePowerUpDecorator(new PowerUpItem(), player);
            p.updatePowerUpEffect();
            hitPowerUpArray[1] = false;
            //probably implement the power-up functionality here
        }

        //Log.d("Room2 Position",  "x: " + player.getX() + " y: " + player.getY());
        if (shouldMove) {
            if (coords[0] == 200 && coords[1] <= 715 && coords[1] >= 700) {
                Intent intent = new Intent(this, Room3.class);
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

    public void launchGameLoseScreen() {
        moveTimer.cancel();
        Intent intent = new Intent(this, EndingScreen.class);
        startActivity(intent);
    }
}
