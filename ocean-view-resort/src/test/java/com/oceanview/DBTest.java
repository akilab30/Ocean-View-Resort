package com.oceanview;

import com.oceanview.util.DBConnection;
import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("✅ Database Connected Successfully!");
        } else {
            System.out.println("❌ Database Connection Failed!");
        }
    }
}