package com.anhan.rougle.controller;

import com.anhan.rougle.word.WordHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("word")
public class WordController {
    WordHandler wordHandler;

    public WordController(WordHandler wordHandler){
        this.wordHandler = wordHandler;
    }

    /***
     * Get daily words
     * @return daily word values
     */
    @GetMapping("/{day}")
    public List<String> getWords(@PathVariable int day) {
        return this.wordHandler.getWords(day);
    }

    /***
     * Get random words
     * @return random word values
     */
    @GetMapping("/random")
    public List<String> getRandom() {
        return this.wordHandler.getRandomWords();
    }
}
