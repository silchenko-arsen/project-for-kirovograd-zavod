package org.example.dao;

import org.example.exception.DataProcessingException;
import org.example.model.Product;
import org.example.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String QUERY_FOR_INSERT_PRODUCT = "INSERT INTO products(number, title, price, type) VALUES(?, ?, ?, ?)";

    @Override
    public void create(List<Product> products) {
        for (Product product : products) {
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FOR_INSERT_PRODUCT)) {
                preparedStatement.setLong(1, product.getNumber());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setBigDecimal(3, product.getPrice());
                preparedStatement.setInt(4, product.getType());
                preparedStatement.executeUpdate();
                System.out.println("Product saved to db: " + product);
            } catch (SQLException e) {
                throw new DataProcessingException("Can`t create product: " + product, e);
            }
        }
    }
}
