package org.example.dao;

import org.example.exception.DataProcessingException;
import org.example.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreatorDaoImpl implements TableCreatorDao {

    public void createTable(String[] queriesForCreationTable) {
        for (String queryForCreationTable : queriesForCreationTable) {
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(queryForCreationTable)) {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DataProcessingException("Can`t create table \"products\" ", e);
            }
        }
    }
}

