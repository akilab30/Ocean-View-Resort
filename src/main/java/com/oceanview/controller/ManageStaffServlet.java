package com.oceanview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.StaffDAO;
import com.oceanview.model.Staff;

@WebServlet("/manageStaff")
public class ManageStaffServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("username") == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }

        StaffDAO dao = new StaffDAO();
        List<Staff> staffList = dao.getAllStaff();

        request.setAttribute("staffList", staffList);

        request.getRequestDispatcher("/staff/manageStaff.jsp")
               .forward(request,response);
    }
}