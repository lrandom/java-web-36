package luan.niit.com.javaweb36.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.db.ProductDAO;
import luan.niit.com.javaweb36.models.CartItem;
import luan.niit.com.javaweb36.models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/add_to_cart")
public class AddToCartServlet extends HttpServlet {
    public static final String CART_NAME = "cart";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        //lấy ra sản phẩm muốn thêm vào giỏ hàng dựa vào id
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.get(id);
        //lấy ra giỏ hàng từ session

        ArrayList<CartItem> cart = new ArrayList<>();
        if (req.getSession().getAttribute(CART_NAME) != null) {
            cart = (ArrayList<CartItem>) req.getSession().getAttribute(CART_NAME);
        }

        //check xem sản phẩm đã có trong giỏ hàng chưa
        for (CartItem cartItem : cart) {
            if (cartItem.getProduct().getId() == id) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                //lưu ngược lại cart vào session
                req.getSession().setAttribute(CART_NAME, cart);
                resp.sendRedirect(req.getContextPath() + "/cart");
                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cart.add(cartItem);
        //lưu ngược lại cart vào session
        req.getSession().setAttribute(CART_NAME, cart);

        resp.sendRedirect(req.getContextPath() + "/cart");
    }

}
