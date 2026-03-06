package com.oceanview.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // nothing needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String contextPath = req.getContextPath();
        String uri = req.getRequestURI();
        String path = uri.substring(contextPath.length());

        boolean isPublic = isPublicPath(path);

        if (!isPublic) {

            HttpSession session = req.getSession(false);

            boolean loggedIn =
                    session != null && session.getAttribute("user") != null;

            if (!loggedIn) {

                res.sendRedirect(contextPath + "/login.jsp");
                return;
            }

            // prevent back button caching
            res.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
            res.setHeader("Pragma","no-cache");
            res.setDateHeader("Expires",0);
        }

        chain.doFilter(request,response);
    }

    private boolean isPublicPath(String path) {

        if (path.equals("/") ||
            path.equals("/login") ||
            path.equals("/login.jsp") ||
            path.equals("/index.jsp") ||
            path.equals("/logout")) {

            return true;
        }

        // static resources
        if (path.startsWith("/css/") ||
            path.startsWith("/images/") ||
            path.startsWith("/js/")) {

            return true;
        }

        return false;
    }

    @Override
    public void destroy() {
    }
}