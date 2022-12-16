package com.anhan.rougle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("powerup")
public class PowerupController {

    /***
     * @param num
     * @return array of random powerups
     */
    @GetMapping("/{num}")
    public List<String> getPowerups(@PathVariable int num) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++){
            arrayList.add(String.valueOf(i));
        }
        return arrayList;
    }
}
