package com.oceanview.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;
import com.oceanview.util.BillCalculator;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Reservation r = new Reservation();
            r.setGuestName(req.getParameter("guestName"));
            r.setAddress(req.getParameter("address"));
            r.setContact(req.getParameter("contact"));
            r.setRoomType(req.getParameter("roomType"));
            r.setCheckIn(sdf.parse(req.getParameter("checkIn")));
            r.setCheckOut(sdf.parse(req.getParameter("checkOut")));

            LocalDate in = r.getCheckIn().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate out = r.getCheckOut().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();

            int nights = (int) ChronoUnit.DAYS.between(in, out);
            r.setNights(nights);

            double bill = BillCalculator.calculateBill(in, out, r.getRoomType());
            r.setTotalAmount(bill);

            ReservationDAO dao = new ReservationDAO();
            dao.saveReservation(r);

            req.getSession().setAttribute("bill", r);
            res.sendRedirect("bill.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("reservation.jsp?error=1");
        }
    }
}