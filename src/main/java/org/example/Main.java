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
    private static String INIT_TABLE = "src/main/resources/init_table.sql";
    private static String TEST_FILE = "src/main/resources/table_goods.csv";
    public static void main(String[] args) {
        Reader reader = new Reader();
        String[] text = reader.read(TEST_FILE);
        String[] queriesForTable = reader.read(INIT_TABLE);
        TableCreatorDao tableCreator = new TableCreatorDaoImpl();
        tableCreator.createTable(queriesForTable);
        Formatter formatter = new Formatter();
        List<Product> products = formatter.createProducts(text);
        ProductDao productDao = new ProductDaoImpl();
        productDao.create(products);
    }
}
