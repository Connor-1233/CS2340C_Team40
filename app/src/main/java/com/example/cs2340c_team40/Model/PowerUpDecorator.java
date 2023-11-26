package com.example.cs2340c_team40.Model;

public abstract class PowerUpDecorator implements PowerUp {
    private PowerUp power;
    private Player player;

    public PowerUpDecorator(PowerUp power, Player player) {
        this.power = power;
        this.player = player;
    }

    public void updatePowerUpEffect() {
        power.updatePowerUpEffect();
    }

    public Player getPlayer() {
        return player;
    }
}
