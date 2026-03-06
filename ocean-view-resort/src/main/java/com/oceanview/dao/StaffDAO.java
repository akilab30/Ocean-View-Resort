package com.oceanview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.oceanview.model.Staff;
import com.oceanview.util.DBConnection;

public class StaffDAO {

    // ADD STAFF
    public void addStaff(Staff s) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO staff(name, role, contact, email) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getRole());
            ps.setString(3, s.getContact());
            ps.setString(4, s.getEmail());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET ALL STAFF
    public List<Staff> getAllStaff() {

        List<Staff> list = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM staff";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Staff s = new Staff();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setRole(rs.getString("role"));
                s.setContact(rs.getString("contact"));
                s.setEmail(rs.getString("email"));

                list.add(s);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE STAFF
    public void deleteStaff(int id) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM staff WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}