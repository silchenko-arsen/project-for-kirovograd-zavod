package org.example.service;

import org.example.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Formatter {
    public List<Product> createProducts(String text) {
        List<Product> products = new ArrayList<>();
        String newText = text.replaceAll(",",".");
        final String[] lines = newText.split("13");
        for (String line : lines) {
            String[] words = line.split("\t");
            Product product = new Product();
            product.setNumber(Long.parseLong(words[0]));
            product.setName(words[1]);
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(words[2])));
            product.setType(Integer.parseInt(words[3]));
            products.add(product);
        }
        return products;
    }
}
