package com.anhan.rougle.controller;

import com.anhan.rougle.word.WordUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    private final WordUtil wordUtil;

    public AppController(WordUtil wordUtil){
        this.wordUtil = wordUtil;
    }

    /***
     * Server health check
     * @return "Welcome to Rougle!"
     */
    @GetMapping("/")
    public String index() {
        return "Welcome to Rougle!";
    }

//    @GetMapping("/test")
//    public List<String> getTest() {
////        return wordUtil.getDictionary();
//    }

}
