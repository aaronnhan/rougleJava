package com.anhan.rougle.controller;

import com.anhan.rougle.powerup.PowerupHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("powerup")
public class PowerupController {
    private PowerupHandler powerupHandler;

    public PowerupController(PowerupHandler powerupHandler){
        this.powerupHandler = powerupHandler;
    }

    /***
     * @param num
     * @return array of random powerups
     */
    @GetMapping("/{num}")
    public List<String> getPowerups(@PathVariable int num) {
        return this.powerupHandler.getPowerups(num);
    }
}
