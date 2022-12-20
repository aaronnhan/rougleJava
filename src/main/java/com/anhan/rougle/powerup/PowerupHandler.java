package com.anhan.rougle.powerup;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PowerupHandler {
    private PowerUp powerUp;

    public PowerupHandler(PowerUp powerUp){
        this.powerUp = powerUp;
    }

    /**
     * return list of i powerups
     * @param i number of powerups to return
     * @return list of i powerups
     */
    public List<String> getPowerups(int i){
        return this.powerUp.getPowerups(i);
    }
}
