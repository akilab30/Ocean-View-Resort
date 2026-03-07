package com.oceanview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oceanview.model.Reservation;
import com.oceanview.util.DBConnection;

public class ReservationDAO {

    /* =========================
       SAVE RESERVATION
       ========================= */
    public boolean saveReservation(Reservation r) {

        String sql = "INSERT INTO reservations " +
                "(guest_name, address, contact, email, room_type, nights, check_in, check_out, total_amount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, r.getGuestName());
            ps.setString(2, r.getAddress());
            ps.setString(3, r.getContact());
            ps.setString(4, r.getEmail());          // ✅ FIXED
            ps.setString(5, r.getRoomType());
            ps.setInt(6, r.getNights());
            ps.setDate(7, new java.sql.Date(r.getCheckIn().getTime()));
            ps.setDate(8, new java.sql.Date(r.getCheckOut().getTime()));
            ps.setDouble(9, r.getTotalAmount());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        r.setId(rs.getInt(1)); // auto-generated ID
                    }
                }
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* =========================
       VIEW ALL RESERVATIONS
       ========================= */
    public List<Reservation> getAllReservations() {

        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations ORDER BY reservation_id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reservation r = new Reservation();

                r.setId(rs.getInt("reservation_id"));
                r.setGuestName(rs.getString("guest_name"));
                r.setAddress(rs.getString("address"));
                r.setContact(rs.getString("contact"));
                r.setEmail(rs.getString("email"));   // ✅ FIXED
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

    /* =========================
       DELETE RESERVATION
       ========================= */
    public boolean deleteReservation(int reservationId) {

        String sql = "DELETE FROM reservations WHERE reservation_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reservationId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* =========================
       GET RESERVATION BY ID
       ========================= */
    public Reservation getReservationById(int reservationId) {

        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";
        Reservation r = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reservationId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    r = new Reservation();

                    r.setId(rs.getInt("reservation_id"));
                    r.setGuestName(rs.getString("guest_name"));
                    r.setAddress(rs.getString("address"));
                    r.setContact(rs.getString("contact"));
                    r.setEmail(rs.getString("email"));
                    r.setRoomType(rs.getString("room_type"));
                    r.setNights(rs.getInt("nights"));
                    r.setCheckIn(rs.getDate("check_in"));
                    r.setCheckOut(rs.getDate("check_out"));
                    r.setTotalAmount(rs.getDouble("total_amount"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    /* =========================
       UPDATE RESERVATION
       ========================= */
    public boolean updateReservation(Reservation r) {

        String sql = "UPDATE reservations SET " +
                "guest_name=?, address=?, contact=?, email=?, room_type=?, nights=?, " +
                "check_in=?, check_out=?, total_amount=? " +
                "WHERE reservation_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getGuestName());
            ps.setString(2, r.getAddress());
            ps.setString(3, r.getContact());
            ps.setString(4, r.getEmail());
            ps.setString(5, r.getRoomType());
            ps.setInt(6, r.getNights());
            ps.setDate(7, new java.sql.Date(r.getCheckIn().getTime()));
            ps.setDate(8, new java.sql.Date(r.getCheckOut().getTime()));
            ps.setDouble(9, r.getTotalAmount());
            ps.setInt(10, r.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}