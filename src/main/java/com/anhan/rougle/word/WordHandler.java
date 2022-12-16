package com.anhan.rougle.word;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WordHandler {
    private WordUtil wordUtil;

    public WordHandler(WordUtil wordUtil){
        this.wordUtil = wordUtil;
    }

    //TODO
    public List<String> getDailyWords(){
        ArrayList<String> words = new ArrayList();
        return words;
    }

    //TODO
    public List<String> getRandomWords(){
        ArrayList<String> words = new ArrayList();
        return words;
    }

    //TODO
    public List<String> getHistoricalWords(){
        ArrayList<String> words = new ArrayList();
        return words;
    }
}
