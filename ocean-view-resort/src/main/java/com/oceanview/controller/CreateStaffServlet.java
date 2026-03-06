package com.oceanview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.StaffDAO;
import com.oceanview.model.Staff;

@WebServlet("/createStaff")
public class CreateStaffServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("username") == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }

        request.getRequestDispatcher("/staff/createStaff.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Staff s = new Staff();

        s.setName(request.getParameter("name"));
        s.setRole(request.getParameter("role"));
        s.setContact(request.getParameter("contact"));
        s.setEmail(request.getParameter("email"));

        StaffDAO dao = new StaffDAO();

        dao.addStaff(s);

        response.sendRedirect(request.getContextPath()+"/manageStaff");
    }
}