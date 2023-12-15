package org.example.dao;

import org.example.model.Product;
import java.util.List;

public interface ProductDao {
    void create(List<Product> product);
}
