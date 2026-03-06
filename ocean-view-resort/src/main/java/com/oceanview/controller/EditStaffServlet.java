package com.oceanview.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.StaffDAO;
import com.oceanview.model.Staff;

@WebServlet("/editStaff")
public class EditStaffServlet extends HttpServlet {

    // LOAD STAFF DATA
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            StaffDAO dao = new StaffDAO();
            Staff staff = dao.getStaffById(id);

            request.setAttribute("staff", staff);

            RequestDispatcher rd = request.getRequestDispatcher("/staff/editstaff.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE STAFF
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String role = request.getParameter("role");
            String contact = request.getParameter("contact");
            String email = request.getParameter("email");

            Staff s = new Staff();
            s.setId(id);
            s.setName(name);
            s.setRole(role);
            s.setContact(contact);
            s.setEmail(email);

            StaffDAO dao = new StaffDAO();
            boolean updated = dao.updateStaff(s);

            if(updated){
                response.sendRedirect(request.getContextPath() + "/manageStaff");
            }else{
                response.getWriter().println("Staff update failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}