package com.oceanview.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.oceanview.util.DBConnection;

public class DatabaseConnectionTest {

    @Test
    public void testDatabaseConnection() {

        Connection conn = DBConnection.getConnection();

        assertNotNull(conn, "Database connection should not be null");
    }
}