package org.example;

import org.example.dao.ProductDao;
import org.example.dao.ProductDaoImpl;
import org.example.dao.TableCreatorDao;
import org.example.dao.TableCreatorDaoImpl;
import org.example.model.Product;
import org.example.service.Formatter;
import org.example.service.Reader;
import java.util.List;

public class Main {
    private static String INIT_TABLE_FILE = "src/main/resources/init_table.sql";
    private static String TEST_FILE = "src/main/resources/table_goods.csv";
    public static void main(String[] args) {
        Reader reader = new Reader();
        String[] queriesForTable = reader.read(INIT_TABLE_FILE);
        TableCreatorDao tableCreator = new TableCreatorDaoImpl();
        tableCreator.createTable(queriesForTable);
        String[] stringProducts = reader.read(TEST_FILE);
        Formatter formatter = new Formatter();
        List<Product> products = formatter.createProducts(stringProducts);
        ProductDao productDao = new ProductDaoImpl();
        productDao.create(products);
    }
}
