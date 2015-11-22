package com.uluru.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by ukawa on 15/11/22.
 */
public class ConnectionManager implements AutoCloseable {
    private final String CONNECTION_URL = "jdbc:mysql://160.16.94.166:54321/ULURU_DB?useUnicode=true&characterEncoding=utf8";
    private final String DB_USER = "uluru";
    private final String DB_PASS = "Mysql/Uluru";

    private Connection conn;

    public ConnectionManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws Exception {
        conn.close();
    }
}
