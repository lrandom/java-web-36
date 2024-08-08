package luan.niit.com.javaweb36;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import luan.niit.com.javaweb36.models.User;

import java.io.IOException;

@WebServlet(name = "CreateSession", value = "/create-session")
public class CreateSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        User luan = new User();
        luan.setEmail("luan@gmail.com");
        luan.setName("Luan");
        httpSession.setAttribute("user", luan);
        resp.getWriter().println("Session created successfully");
    }
}
