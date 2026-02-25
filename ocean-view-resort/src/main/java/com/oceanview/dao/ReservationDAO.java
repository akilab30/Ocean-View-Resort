package com.oceanview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oceanview.model.Reservation;
import com.oceanview.util.DBConnection;

public class ReservationDAO {

    // SAVE
    public boolean saveReservation(Reservation r) {

        String sql = "INSERT INTO reservations " +
                "(guest_name, address, contact, room_type, nights, check_in, check_out, total_amount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getGuestName());
            ps.setString(2, r.getAddress());
            ps.setString(3, r.getContact());
            ps.setString(4, r.getRoomType());
            ps.setInt(5, r.getNights());
            ps.setDate(6, new java.sql.Date(r.getCheckIn().getTime()));
            ps.setDate(7, new java.sql.Date(r.getCheckOut().getTime()));
            ps.setDouble(8, r.getTotalAmount());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ✅ VIEW ALL (FIXES ERROR)
    public List<Reservation> getAllReservations() {

        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setGuestName(rs.getString("guest_name"));
                r.setAddress(rs.getString("address"));
                r.setContact(rs.getString("contact"));
                r.setRoomType(rs.getString("room_type"));
                r.setNights(rs.getInt("nights"));
                r.setCheckIn(rs.getDate("check_in"));
                r.setCheckOut(rs.getDate("check_out"));
                r.setTotalAmount(rs.getDouble("total_amount"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}