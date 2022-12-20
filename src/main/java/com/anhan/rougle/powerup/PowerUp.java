package com.anhan.rougle.powerup;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PowerUp {
    public List<String> getPowerups(int i){
        List<String> res =  getPowerupList();
        Collections.shuffle(res);
        return res.stream().limit(i).collect(Collectors.toList());
    }

    public List<String> getPowerupList(){
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            res.add(String.valueOf(i));
        }
        return res;
    }
}
