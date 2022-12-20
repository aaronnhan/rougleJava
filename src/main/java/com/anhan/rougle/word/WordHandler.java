package com.anhan.rougle.word;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class WordHandler {
    private WordDictionary wordDictionary;
    private Random random;

    public WordHandler(WordDictionary wordDictionary){
        this.wordDictionary = wordDictionary;
        this.random = new Random();
    }

    /**
     * Return words at index
     * @param i index to get words at
     * @return list of words at index i
     */
    public List<String> getWords(int i){
        return this.wordDictionary.getIndex(i);
    }

    /**
     * Return words at random index
     * @return return words at random index
     */
    public List<String> getRandomWords(){
        return getWords(this.random.nextInt(Integer.MAX_VALUE));
    }
}
