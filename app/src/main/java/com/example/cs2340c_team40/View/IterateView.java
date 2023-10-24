package com.example.cs2340c_team40.View;
import android.content.Context;
import android.content.Intent;

import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.Model.Room;

import java.util.Timer;
import java.util.TimerTask;

public class IterateView {

    private static Timer dotTimer = new Timer();
    public static void checkA(Room room, Player player, Context context, int roomNum) {
        dotTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (roomNum == 1) {
                            if (room.checkLocation(player.getX() / player.getPixelWidth(),
                                    player.getY() / player.getPixelHeight()) == 2) {
                                Intent intent = new Intent(context, Room2.class);
                                context.startActivity(intent);
                            }
                        }

                        if (roomNum == 2) {
                            if (room.checkLocation(player.getX() / player.getPixelWidth(),
                                    player.getY() / player.getPixelHeight()) == 2) {
                                Intent intent = new Intent(context, Room3.class);
                                context.startActivity(intent);
                            }
                        }

                        if (roomNum == 3) {
                            if (room.checkLocation(player.getX() / player.getPixelWidth(),
                                    player.getY() / player.getPixelHeight()) == 2) {
                                Intent intent = new Intent(context, EndingScreen.class);
                                context.startActivity(intent);
                            }
                        }
                    }
                });
            }
        }, 0, 100); // Check every .1 seconds
    }
}