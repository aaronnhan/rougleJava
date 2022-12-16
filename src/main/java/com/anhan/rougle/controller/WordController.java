package com.anhan.rougle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("word")
public class WordController {

    /***
     * Get daily words
     * @return daily word values
     */
    @GetMapping("/daily")
    public String getDaily() {
        return "Daily Word List";
    }

    /***
     * Get random words
     * @return random word values
     */
    @GetMapping("/random")
    public String getRandom() {
        return "Random Word List";
    }

    /***
     * Get random words
     * @return random word values
     */
    @GetMapping("/historical/{day}")
    public String getHistorical(@PathVariable String day) {
        return "Historical Word List from " + day;
    }
}
