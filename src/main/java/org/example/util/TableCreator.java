package org.example.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class TableCreator {

    public void createTable(String fileForCreateTable) {
        File scriptFile = new File(fileForCreateTable);

        try (Connection connection = ConnectionUtil.getConnection();
             Statement statement = connection.createStatement();
             BufferedReader br = new BufferedReader(new FileReader(scriptFile))) {
            StringBuilder query = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(";")) {
                    query.append(line, 0, line.indexOf(';'));
                    statement.execute(query.toString().trim());
                    query.setLength(0);
                } else {
                    query.append(line).append(" ");
                }
            }
        } catch (Exception ex) {
            System.out.println("TableReCreatorDao.createTable failed...");
            ex.printStackTrace();
        }
    }
}
