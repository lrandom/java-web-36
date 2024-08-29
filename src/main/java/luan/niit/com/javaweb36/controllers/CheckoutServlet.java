package luan.niit.com.javaweb36.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.db.OrderDAO;
import luan.niit.com.javaweb36.models.CartItem;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("cart") == null) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }
        ArrayList<CartItem> cart = (ArrayList<CartItem>) req.getSession().getAttribute("cart");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String note = req.getParameter("note");
        float subTotal = 0;
        for (CartItem item : cart) {
            subTotal += item.getProduct().getPrice() * item.getQuantity();
        }
        float total = subTotal + (subTotal * 10 / 100);

        OrderDAO orderDAO = new OrderDAO();
        int orderId = orderDAO.insertOrder(name, phone, address, note, subTotal, total);
        if (orderId > 0) {
            for (CartItem item : cart) {
                orderDAO.insertOrderDetail(item, orderId);
            }
            req.getSession().removeAttribute("cart");
            resp.sendRedirect(req.getContextPath() + "/checkout-success");
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}
