package luan.niit.com.javaweb36;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreateCookieServlet", value = "/create-cookie")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("school_name","NIIT");
        cookie.setMaxAge(60*15);//15 minutes
        resp.addCookie(cookie);
        resp.getWriter().println("Cookie created successfully");
    }
}
