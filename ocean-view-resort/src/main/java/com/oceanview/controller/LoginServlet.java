package com.oceanview.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.UserDAO;
import com.oceanview.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.login(username, password);

        if (user != null) {

            HttpSession session = request.getSession(true);

            session.setAttribute("user", user);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());

            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");

        } else {

            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp")
                   .forward(request, response);
        }
    }
}