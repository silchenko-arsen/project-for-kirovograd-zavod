package org.example.service;

import org.example.exception.FileNameException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Reader {
    private static final String LINE_SEPARATOR = "\n";
    private static final String LINE_SPLITTER = ";\n";
    private static final String LINE_FOR_CONTAINS = ";";
    public String[] read(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(LINE_SEPARATOR);
            }
            if (stringBuilder.toString().contains(LINE_FOR_CONTAINS)){
                return stringBuilder.toString().split(LINE_SPLITTER);
            }
            return stringBuilder.toString().split(LINE_SEPARATOR);
        } catch (IOException ex) {
            throw new FileNameException("Can't read data from the file: " + fileName, ex);
        }
    }
}
