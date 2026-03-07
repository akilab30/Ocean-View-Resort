package com.oceanview.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

public class DeleteReservationTest {

    @Test
    public void testDeleteReservation() {

        ReservationDAO dao = new ReservationDAO();

        Reservation r = new Reservation();
        r.setGuestName("Delete Test");
        r.setAddress("Negombo");
        r.setContact("0712345678");
        r.setEmail("delete@test.com");
        r.setRoomType("Standard");
        r.setNights(1);
        r.setCheckIn(new Date());
        r.setCheckOut(new Date());
        r.setTotalAmount(8000);

        dao.saveReservation(r);

        int reservationId = r.getId();

        boolean deleted = dao.deleteReservation(reservationId);

        assertTrue(deleted, "Reservation should be deleted successfully");
    }
}