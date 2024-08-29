package luan.niit.com.javaweb36.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.models.CartItem;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/update_quantity")
public class UpdateQuantityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        ArrayList<CartItem> cart = new ArrayList<>();
        if (req.getSession().getAttribute("cart") != null) {
            cart = (ArrayList<CartItem>) req.getSession().getAttribute("cart");
        }
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                cart.get(i).setQuantity(cart.get(i).getQuantity() + quantity);
                if (cart.get(i).getQuantity() <= 0) {
                    cart.remove(i);
                }
                break;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/cart");

    }
}
