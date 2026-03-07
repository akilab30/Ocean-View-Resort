package com.oceanview;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

public class AddReservationTest {

    @Test
    public void testAddReservation() {

        Reservation reservation = new Reservation();

        reservation.setGuestName("JUnit Test Guest");
        reservation.setAddress("Colombo");
        reservation.setContact("0771234567");
        reservation.setEmail("junit@test.com");
        reservation.setRoomType("Deluxe");
        reservation.setNights(2);
        reservation.setCheckIn(new Date());
        reservation.setCheckOut(new Date());
        reservation.setTotalAmount(20000);

        ReservationDAO dao = new ReservationDAO();

        boolean result = dao.saveReservation(reservation);

        assertTrue(result, "Reservation should be added successfully");
    }
}