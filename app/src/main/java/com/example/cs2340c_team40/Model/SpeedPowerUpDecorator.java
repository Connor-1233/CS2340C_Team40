package com.example.cs2340c_team40.Model;


public class SpeedPowerUpDecorator extends PowerUpDecorator {
    public SpeedPowerUpDecorator(PowerUp power, Player player) {
        super(power, player);
    }

    public void updatePowerUpEffect() {
        super.updatePowerUpEffect();
        getPlayer().setSpeed(10);
    }
}
