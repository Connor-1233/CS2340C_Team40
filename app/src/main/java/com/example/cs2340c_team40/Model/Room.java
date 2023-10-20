package com.example.cs2340c_team40.Model;

public class Room {
    private int[][] roomArray;

    public Room() {
        roomArray = new int[32][32];
    }
    public void addObject(int x, int y, int object) {
        roomArray[x][y] = object;
    }
    public int checkLocation(int x, int y) {
        return roomArray[x][y];
    }
}
