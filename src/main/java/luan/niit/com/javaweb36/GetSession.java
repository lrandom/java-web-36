package luan.niit.com.javaweb36;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import luan.niit.com.javaweb36.models.User;

import java.io.IOException;

@WebServlet(name = "GetSession", value = "/get-session")
public class GetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        if (user != null) {
            resp.getWriter().write("Name: " + user.getName());
            resp.getWriter().write("Email: " + user.getEmail());
        }
    }
}
