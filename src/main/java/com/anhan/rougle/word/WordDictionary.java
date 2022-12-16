package com.anhan.rougle.word;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class WordDictionary {
    @Value("${FIVE_WORD_PATH}")
    String FIVE_WORD_PATH;
    @Value("${SIX_WORD_PATH}")
    String SIX_WORD_PATH;
    @Value("${SEVEN_WORD_PATH}")
    String SEVEN_WORD_PATH;
    @Value("${EIGHT_WORD_PATH}")
    String EIGHT_WORD_PATH;
    @Value("${SHUFFLE_SEED}")
    String SHUFFLE_SEED;

    public WordDictionary(){
    }

    public HashMap<Integer, List<String>> getDictionary(){
        ArrayList<String> fiveList = new ArrayList<>();
        ArrayList<String> sixList = new ArrayList<>();
        ArrayList<String> sevenList = new ArrayList<>();
        ArrayList<String> eightList = new ArrayList<>();
        try {
            File fileFive = getResourceFile(FIVE_WORD_PATH);
            File fileSix = getResourceFile(SIX_WORD_PATH);
            File fileSeven = getResourceFile(SEVEN_WORD_PATH);
            File fileEight = getResourceFile(EIGHT_WORD_PATH);

            Scanner myReader = new Scanner(fileFive);
            while (myReader.hasNextLine()) {
                fiveList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(fiveList, getSeededRandom());

            myReader = new Scanner(fileSix);
            while (myReader.hasNextLine()) {
                sixList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(sixList, getSeededRandom());

            myReader = new Scanner(fileSeven);
            while (myReader.hasNextLine()) {
                sevenList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(sevenList, getSeededRandom());

            myReader = new Scanner(fileEight);
            while (myReader.hasNextLine()) {
                eightList.add(myReader.nextLine());
            }
            myReader.close();
            Collections.shuffle(eightList, getSeededRandom());
        } catch (FileNotFoundException e) {}

        HashMap<Integer, List<String>> wordsDictionary = new HashMap();
        wordsDictionary.put(5, fiveList);
        wordsDictionary.put(6, sixList);
        wordsDictionary.put(7, sevenList);
        wordsDictionary.put(8, eightList);
        return wordsDictionary;
    }

    public Random getSeededRandom(){
        return new Random(Long.getLong(SHUFFLE_SEED));
    }

    private File getResourceFile(final String fileName)
    {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);

        if(url == null) {
            throw new IllegalArgumentException(fileName + " is not found 1");
        }

        File file = new File(url.getFile());

        return file;
    }
}
