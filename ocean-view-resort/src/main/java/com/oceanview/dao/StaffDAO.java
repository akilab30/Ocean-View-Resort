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

        String sql = "INSERT INTO staff(name, role, contact, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getRole());
            ps.setString(3, s.getContact());
            ps.setString(4, s.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // GET ALL STAFF
    public List<Staff> getAllStaff() {

        List<Staff> list = new ArrayList<>();

        String sql = "SELECT * FROM staff ORDER BY id DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Staff s = new Staff();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setRole(rs.getString("role"));
                s.setContact(rs.getString("contact"));
                s.setEmail(rs.getString("email"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // GET STAFF BY ID
    public Staff getStaffById(int id) {

        Staff s = null;

        String sql = "SELECT * FROM staff WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                s = new Staff();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setRole(rs.getString("role"));
                s.setContact(rs.getString("contact"));
                s.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }


    // UPDATE STAFF (returns success status)
    public boolean updateStaff(Staff s) {

        String sql = "UPDATE staff SET name=?, role=?, contact=?, email=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getRole());
            ps.setString(3, s.getContact());
            ps.setString(4, s.getEmail());
            ps.setInt(5, s.getId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // DELETE STAFF
    public void deleteStaff(int id) {

        String sql = "DELETE FROM staff WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}