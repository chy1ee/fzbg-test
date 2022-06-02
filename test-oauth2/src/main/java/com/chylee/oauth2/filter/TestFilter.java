package com.chylee.oauth2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebFilter(urlPatterns = "/*",filterName = "testFilter")
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;


        response.addHeader("Access-Control-Allow-Origin", "http://192.168.1.109:9000");
        response.addHeader("Access-Control-Allow-Methods", "*");

        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            System.out.println("cookies is null");
        else {
            for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies[i].getName() + "=" + cookies[i].getValue());
            }
        }

        String uri = request.getRequestURI();
        if ("/code".equals(uri)) {
            String url = request.getParameter("redirect_url");
            if (url == null)
                url = request.getRequestURL().toString();

            response.setHeader("Origin", "http://192.168.1.109:9000");

            if (url.contains("?"))
                response.sendRedirect(url + "&code=" + UUID.randomUUID());
            else
                response.sendRedirect(url + "?code=" + UUID.randomUUID());
        }
    }
}
