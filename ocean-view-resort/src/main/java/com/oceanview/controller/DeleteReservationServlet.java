package com.oceanview.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.ReservationDAO;

@WebServlet("/deleteReservation")
public class DeleteReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));

        ReservationDAO dao = new ReservationDAO();
        dao.deleteReservation(id);

        res.sendRedirect(req.getContextPath() + "/viewReservation");
    }
}