package com.example.cs2340c_team40.Model;


public class ScorePowerUpDecorator extends PowerUpDecorator {
    public ScorePowerUpDecorator(PowerUp power, Player player) {
        super(power, player);
    }

    public void updatePowerUpEffect() {
        super.updatePowerUpEffect();
        getPlayer().setScore(getPlayer().getScore() + 100);
    }
}
