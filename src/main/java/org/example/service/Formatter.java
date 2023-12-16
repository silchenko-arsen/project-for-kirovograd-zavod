package org.example.service;

import org.example.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Formatter {
    private static final String LINE_SPLITTER = "\t";
    private static final char REGEX = ',';
    private static final char REPLACEMENT = '.';
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;
    private static final int THIRD_INDEX = 3;

    public List<Product> createProducts(String[] lines) {
        List<Product> products = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.replace(REGEX, REPLACEMENT).split(LINE_SPLITTER);
            Product product = new Product();
            product.setNumber(Long.parseLong(words[ZERO_INDEX]));
            product.setName(words[FIRST_INDEX]);
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(words[SECOND_INDEX])));
            product.setType(Integer.parseInt(words[THIRD_INDEX]));
            products.add(product);
        }
        return products;
    }
}
