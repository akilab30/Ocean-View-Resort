package com.oceanview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.StaffDAO;

@WebServlet("/deleteStaff")
public class DeleteStaffServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        StaffDAO dao = new StaffDAO();
        dao.deleteStaff(id);

        response.sendRedirect(request.getContextPath()+"/manageStaff");
    }
}