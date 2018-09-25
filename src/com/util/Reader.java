package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gabor on 2018.02.17..
 */
public class Reader {

    public List<String> readResource(String fileName) {

        List<String> list = new ArrayList<>();
        try (InputStream inputStream = Reader.class.getResourceAsStream(fileName)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            return list;

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
}
