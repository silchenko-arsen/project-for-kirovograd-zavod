package org.example.service;

import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.Character.LINE_SEPARATOR;

public class Reader {
    public String readFromFile(String fromFileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(LINE_SEPARATOR);
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read data from the file " + fromFileName, e);
        }
        return stringBuilder.toString();
    }
}
