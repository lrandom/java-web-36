package luan.niit.com.javaweb36.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.models.CartItem;
import luan.niit.com.javaweb36.models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CartItem> cart =
                new ArrayList<CartItem>();
        if (req.getSession().getAttribute(AddToCartServlet.CART_NAME) != null) {
            cart = (ArrayList<CartItem>) req.getSession().getAttribute(AddToCartServlet.CART_NAME);
        }
        req.setAttribute("cart", cart);
        float subTotal = 0;
        for (CartItem item : cart) {
            subTotal += item.getProduct().getPrice() * item.getQuantity();
        }
        req.setAttribute("subTotal", subTotal);
        float total = subTotal + (subTotal * 10 / 100);
        req.setAttribute("total", total);
        req.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req, resp);
    }
}
