package com.example.cs2340c_team40.Model;


public class DamagePowerUpDecorator extends PowerUpDecorator {
    public DamagePowerUpDecorator(PowerUp power, Player player) {
        super(power, player);
    }

    public void updatePowerUpEffect() {
        super.updatePowerUpEffect();
        getPlayer().setDamage(35);
    }
}
