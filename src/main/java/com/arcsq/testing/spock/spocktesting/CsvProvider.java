package com.arcsq.testing.spock.spocktesting;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class CsvProvider {

    private InputStream inputStream;

    public CsvProvider(String csv) {
        inputStream = getClass().getClassLoader().getResourceAsStream(csv);
    }

    public Iterator<String[]> provide() {
        Scanner scanner = new Scanner(inputStream);
        return new Iterator<String[]>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

            @Override
            public String[] next() {
                return scanner.next().split(",");
            }
        };
    }
}
