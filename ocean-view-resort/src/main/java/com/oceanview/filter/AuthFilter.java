package com.oceanview.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String uri = request.getRequestURI();
        String context = request.getContextPath();

        HttpSession session = request.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("username") != null);

        boolean publicPage =
        		uri.endsWith("index.jsp") ||
                uri.endsWith("login.jsp") ||
                uri.contains("/login") ||
                uri.contains("/css/") ||
                uri.contains("/images/") ||
                uri.contains("/js/");

        if (loggedIn || publicPage) {

            chain.doFilter(req, res);

        } else {

            response.sendRedirect(context + "/index.jsp");
        }
    }
}