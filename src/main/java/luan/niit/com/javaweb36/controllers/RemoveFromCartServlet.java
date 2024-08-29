package luan.niit.com.javaweb36.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.models.CartItem;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/remove_from_cart")
public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("id"));
        ArrayList<CartItem> cart = new ArrayList<>();
        if (req.getSession().getAttribute("cart") != null) {
            cart = (ArrayList<CartItem>) req.getSession().getAttribute("cart");
        }
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == productId) {
                cart.remove(i);
                break;
            }
        }
        req.getSession().setAttribute("cart", cart);
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
