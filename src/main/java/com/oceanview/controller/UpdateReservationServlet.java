package com.oceanview.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

@WebServlet("/updateReservation")
public class UpdateReservationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        // 🔐 Session validation
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        try {
            Reservation r = new Reservation();

            // ✅ Correct parsing
            r.setId(Integer.parseInt(req.getParameter("id")));
            r.setGuestName(req.getParameter("guestName"));
            r.setAddress(req.getParameter("address"));
            r.setContact(req.getParameter("contact"));
            r.setEmail(req.getParameter("email"));
            r.setRoomType(req.getParameter("roomType"));

            r.setNights(Integer.parseInt(req.getParameter("nights")));

            r.setCheckIn(Date.valueOf(req.getParameter("checkIn")));
            r.setCheckOut(Date.valueOf(req.getParameter("checkOut")));

            r.setTotalAmount(Double.parseDouble(req.getParameter("totalAmount")));

            ReservationDAO dao = new ReservationDAO();
            dao.updateReservation(r);

            res.sendRedirect(req.getContextPath() + "/viewReservation");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            res.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}