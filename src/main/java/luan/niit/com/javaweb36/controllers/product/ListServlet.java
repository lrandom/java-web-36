package luan.niit.com.javaweb36.controllers.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.db.CategoriesDAO;
import luan.niit.com.javaweb36.db.ProductDAO;
import luan.niit.com.javaweb36.models.Categories;
import luan.niit.com.javaweb36.models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListProductServlet", urlPatterns = "/product")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ProductDAO categoriesDAO = new ProductDAO();
        ArrayList<Product> products = categoriesDAO.list();

        //set data vào trong request để gửi qua view
        req.setAttribute("products", products);
        for (Product product : products) {
            System.out.println("product" + product.getName());
        }

        //tải cái trang jsp lên
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }
}
