package org.example;

import org.example.dao.ProductDao;
import org.example.dao.ProductDaoImpl;
import org.example.model.Product;
import org.example.service.Formatter;
import org.example.service.Reader;
import org.example.util.TableCreator;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static String INIT_TABLE = "src/main/resources/init_table.sql";
    private static String TEST_FILE = "src/main/resources/table_goods.csv";
    public static void main(String[] args) throws SQLException {
        TableCreator tableCreator = new TableCreator();
        tableCreator.createTable(INIT_TABLE);
        Reader reader = new Reader();
        String text = reader.readFromFile(TEST_FILE);
        Formatter formatter = new Formatter();
        List<Product> products = formatter.createProducts(text);
        ProductDao productDao = new ProductDaoImpl();
        productDao.create(products);
    }
}
