package com.anhan.rougle.word;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Component
public class WordDictionary {
    private static String FIVE_WORD_PATH = "wordLists/5.txt";
    private static String SIX_WORD_PATH = "wordLists/6.txt";
    private static String SEVEN_WORD_PATH = "wordLists/7.txt";
    private static String EIGHT_WORD_PATH = "wordLists/8.txt";

    WordUtil wordUtil;
    HashMap<Integer, List<String>> dictionary;

    public WordDictionary(WordUtil wordUtil){
        this.wordUtil = wordUtil;
        this.dictionary = getDictionary();
    }

    /***
     * Generate length of words -> list of words hashmap
     * @return dictionary of words
     */
    public HashMap<Integer, List<String>> getDictionary(){
        ArrayList<String> fiveList = new ArrayList<>();
        ArrayList<String> sixList = new ArrayList<>();
        ArrayList<String> sevenList = new ArrayList<>();
        ArrayList<String> eightList = new ArrayList<>();
        try {
            File fileFive = wordUtil.getResourceFile(FIVE_WORD_PATH);
            File fileSix = wordUtil.getResourceFile(SIX_WORD_PATH);
            File fileSeven = wordUtil.getResourceFile(SEVEN_WORD_PATH);
            File fileEight = wordUtil.getResourceFile(EIGHT_WORD_PATH);

            Scanner myReader = new Scanner(fileFive);
            while (myReader.hasNextLine()) {
                fiveList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(fiveList, wordUtil.getSeededRandom());

            myReader = new Scanner(fileSix);
            while (myReader.hasNextLine()) {
                sixList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(sixList, wordUtil.getSeededRandom());

            myReader = new Scanner(fileSeven);
            while (myReader.hasNextLine()) {
                sevenList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(sevenList, wordUtil.getSeededRandom());

            myReader = new Scanner(fileEight);
            while (myReader.hasNextLine()) {
                eightList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(eightList, wordUtil.getSeededRandom());
        } catch (FileNotFoundException e) {}

        HashMap<Integer, List<String>> wordsDictionary = new HashMap();
        wordsDictionary.put(5, fiveList);
        wordsDictionary.put(6, sixList);
        wordsDictionary.put(7, sevenList);
        wordsDictionary.put(8, eightList);

        return wordsDictionary;
    }

    /**
     * get words at index i
     * @param i index to get word at
     * @return Returns list of wards at index i
     */
    public List<String> getIndex(int i){
        ArrayList<String> indexArraylist = new ArrayList<>();
        for(int j = 5; j < 5 + this.dictionary.size(); j++){
            List<String> lengthList = this.dictionary.get(j);
            indexArraylist.add(lengthList.get(i % lengthList.size()));
        }
        return indexArraylist;
    }
}
