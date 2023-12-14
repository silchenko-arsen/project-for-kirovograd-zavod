package org.example.dao;

import org.example.exception.DataProcessingException;
import org.example.model.Product;
import org.example.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String QUERY = "INSERT INTO products(number, title, price, type) VALUES(?, ?, ?, ?)";

    @Override
    public void create(List<Product> products) {
        for (Product product : products) {
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(QUERY,
                         Statement.RETURN_GENERATED_KEYS)) {
                statement.setLong(1, product.getNumber());
                statement.setString(2, product.getName());
                statement.setBigDecimal(3, product.getPrice());
                statement.setInt(4, product.getType());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    Long number = resultSet.getObject(1, Long.class);
                    product.setNumber(number);
                }
                System.out.println("Product saved to db: " + product);
            } catch (SQLException e) {
                throw new DataProcessingException("Can`t create product: " + product, e);
            }
        }
    }
}
