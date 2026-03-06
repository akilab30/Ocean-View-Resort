package com.oceanview.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;
import com.oceanview.util.BillCalculator;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        try {
            // 🔒 Require login
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("username") == null) {
                res.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);

            // Read parameters
            String guestName = trim(req.getParameter("guestName"));
            String address   = trim(req.getParameter("address"));
            String contact   = trim(req.getParameter("contact"));
            String email     = trim(req.getParameter("email"));
            String roomType  = trim(req.getParameter("roomType"));
            String checkInStr  = trim(req.getParameter("checkIn"));
            String checkOutStr = trim(req.getParameter("checkOut"));

            List<String> errors = new ArrayList<>();

            // Validations
            if (isEmpty(guestName)) errors.add("Guest name is required.");
            if (isEmpty(address))   errors.add("Address is required.");

            if (isEmpty(contact)) {
                errors.add("Contact is required.");
            } else if (!contact.matches("^[0-9 +()\\-]{7,20}$")) {
                errors.add("Contact must be 7–20 characters and contain only numbers and + - ( ) spaces.");
            }

            if (isEmpty(email)) {
                errors.add("Email is required.");
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                errors.add("Invalid email format.");
            }

            if (isEmpty(roomType) ||
                !(roomType.equals("Standard") ||
                  roomType.equals("Double") ||
                  roomType.equals("Deluxe"))) {
                errors.add("Please select a valid room type.");
            }

            Date checkIn = null;
            Date checkOut = null;

            if (isEmpty(checkInStr)) {
                errors.add("Check-in date is required.");
            } else {
                try { checkIn = sdf.parse(checkInStr); }
                catch (Exception e) { errors.add("Invalid check-in date."); }
            }

            if (isEmpty(checkOutStr)) {
                errors.add("Check-out date is required.");
            } else {
                try { checkOut = sdf.parse(checkOutStr); }
                catch (Exception e) { errors.add("Invalid check-out date."); }
            }

            if (checkIn != null && checkOut != null) {
                LocalDate in  = checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate out = checkOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (!out.isAfter(in)) {
                    errors.add("Check-out must be after check-in.");
                }
            }

            // ❌ Validation failed → back to form
            if (!errors.isEmpty()) {
                req.setAttribute("errors", errors);
                req.setAttribute("guestName", guestName);
                req.setAttribute("address", address);
                req.setAttribute("contact", contact);
                req.setAttribute("email", email);
                req.setAttribute("roomType", roomType);
                req.setAttribute("checkIn", checkInStr);
                req.setAttribute("checkOut", checkOutStr);

                req.getRequestDispatcher("/reservation.jsp").forward(req, res);
                return;
            }

            // ✅ Build model
            Reservation r = new Reservation();
            r.setGuestName(guestName);
            r.setAddress(address);
            r.setContact(contact);
            r.setEmail(email);
            r.setRoomType(roomType);
            r.setCheckIn(checkIn);
            r.setCheckOut(checkOut);

            LocalDate in  = checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate out = checkOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            int nights = (int) ChronoUnit.DAYS.between(in, out);
            r.setNights(nights);

            double total = BillCalculator.calculateBill(in, out, roomType);
            r.setTotalAmount(total);

            ReservationDAO dao = new ReservationDAO();
            boolean saved = dao.saveReservation(r);

            if (!saved) {
                res.sendRedirect("reservation.jsp?error=1");
                return;
            }

            // ✔ For bill page
            req.getSession().setAttribute("bill", r);
            res.sendRedirect("bill.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("reservation.jsp?error=1");
        }
    }

    private static String trim(String s) {
        return s == null ? null : s.trim();
    }

    private static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}