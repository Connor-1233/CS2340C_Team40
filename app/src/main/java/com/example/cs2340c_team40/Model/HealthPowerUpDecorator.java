package com.example.cs2340c_team40.Model;


public class HealthPowerUpDecorator extends PowerUpDecorator {
    public HealthPowerUpDecorator(PowerUp power, Player player) {
        super(power, player);
    }

    public void updatePowerUpEffect() {
        super.updatePowerUpEffect();
        getPlayer().setHealth(getPlayer().getHealth() + 20);
    }
}
