package com.example.cs2340c_team40.View;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;

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
import com.example.cs2340c_team40.Model.SpeedPowerUpDecorator;
import com.example.cs2340c_team40.Model.Subscriber;
import com.example.cs2340c_team40.Model.Weapon;
import com.example.cs2340c_team40.R;
import com.example.cs2340c_team40.ViewModel.GameScreenViewModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Iterator;

public class Room2 extends Activity {
    private final Player player = Player.getInstance();
    private Weapon weapon = Weapon.getInstance();
    private int counter;
    private Timer moveTimer;
    private ArrayList<Subscriber> entities;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);

        entities = new ArrayList<Subscriber>();
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
        //Log.d("Health", "Health of Player is: " + player.getHealth());

        GameScreenViewModel.initializePlayer(640, 1415, entities, Room2.class);

        player.getEnemyList().add(knight);
        player.getEnemyList().add(ghost);

        EditText displayName = findViewById(R.id.display_player_name_text);
        displayName.setText(player.getName());
        moveTimer = new Timer();
        moveTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    for (Subscriber subscriber : entities) {
                        checkHealth();
                        subscriber.update();
                    }
                    TextView healthText = findViewById(R.id.health_text);
                    player.setHealth(player.getHealth());
                    healthText.setText(String.valueOf(player.getHealth()));

                    TextView scoreTimerText = findViewById(R.id.score_text);
                    player.setScore(player.getScore());
                    scoreTimerText.setText(String.valueOf(player.getScore()));
                });
            }

        }, 0, 50);


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

        GameScreenViewModel.handleRestartButtonClick(this, moveTimer, Room2.class);
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
            case KeyEvent.KEYCODE_L:
                weapon.notifyEnemies();
                updateEnemyList();
                break;
            default:
                return super.onKeyDown(keyCode, event);
            }
        }

        if (hitPowerUpArray[0]) { //we've hit the bottom power-up - Score
            ImageView scorePowerUp = findViewById(R.id.score_powerup);
            scorePowerUp.setVisibility(View.INVISIBLE);
            PowerUp p = new ScorePowerUpDecorator(new PowerUpItem(), player);
            p.updatePowerUpEffect();
            hitPowerUpArray[0] = false;
        } else if (hitPowerUpArray[1]) { //we've hit the top power-up - Damage
            ImageView speedPowerUp = findViewById(R.id.speed_powerup);
            speedPowerUp.setVisibility(View.INVISIBLE);
            PowerUp p = new SpeedPowerUpDecorator(new PowerUpItem(), player);
            p.updatePowerUpEffect();
            hitPowerUpArray[1] = false;
        }

        //Log.d("Room2 Position",  "x: " + player.getX() + " y: " + player.getY());
        if (shouldMove) {
            if (coords[0] >= 195 && coords[0] <= 205 && coords[1] <= 715 && coords[1] >= 700) {
                GameScreenViewModel.launchRoom3(this, moveTimer);
            }
        }
        return true;
    }

    public void checkHealth() {
        if (GameScreenViewModel.isPlayerDead()) {
            GameScreenViewModel.launchGameLoseScreen(this, moveTimer);
        }
    }
    public void updateEnemyList() {
        Log.d("UpdateEnemyList", "Size before update: " + entities.size());
        Iterator<Subscriber> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Subscriber subscriber = iterator.next();
            if (subscriber instanceof Enemy) {
                Enemy enemy = (Enemy) subscriber;
                if (enemy.isEnemyDestroyed()) {
                    ImageView enemySprite = enemy.getSprite();
                    if (enemySprite != null) {
                        ((ViewGroup) enemySprite.getParent()).removeView(enemySprite);
                    }
                    iterator.remove();
                    player.getEnemyList().remove(enemy);
                    player.setScore(player.getScore() + 10);
                }
            }
        }

        Log.d("UpdateEnemyList", "Size after update: " + entities.size());

    }
}
