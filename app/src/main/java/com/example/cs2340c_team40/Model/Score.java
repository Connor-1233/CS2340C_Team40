package com.example.cs2340c_team40.Model;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Score {
    private int score;
    private String name;
    private String time;
    public Score(int score, String name) {
        this.score = score;
        this.name = name;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        time = dtf.format(now);
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }
}
