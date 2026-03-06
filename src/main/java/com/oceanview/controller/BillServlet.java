package com.oceanview.controller;

import com.oceanview.util.BillCalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/bill")
public class BillServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        LocalDate checkIn = LocalDate.parse(req.getParameter("checkIn"));
        LocalDate checkOut = LocalDate.parse(req.getParameter("checkOut"));
        String roomType = req.getParameter("roomType");

        double total = BillCalculator.calculateBill(checkIn, checkOut, roomType);

        req.setAttribute("total", total);
        req.getRequestDispatcher("jsp/bill.jsp").forward(req, res);
    }
}