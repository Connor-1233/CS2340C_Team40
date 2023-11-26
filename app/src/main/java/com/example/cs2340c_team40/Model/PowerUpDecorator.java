package com.example.cs2340c_team40.Model;

public abstract class PowerUpDecorator implements PowerUp {
    private PowerUp player;

    public PowerUpDecorator(PowerUp player) {
        this.player = player;
    }

    public void applyPowerUp() {
        player.applyPowerUp();
    }
}
