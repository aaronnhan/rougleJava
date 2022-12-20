package com.anhan.rougle.word;

import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.Random;

@Component
public class WordUtil {
    private static long SHUFFLE_SEED = 1L;

    public WordUtil(){}

    protected Random getSeededRandom(){
        return new Random(SHUFFLE_SEED);
    }

    protected File getResourceFile(final String fileName)
    {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);

        if(url == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }

        File file = new File(url.getFile());

        return file;
    }
}
