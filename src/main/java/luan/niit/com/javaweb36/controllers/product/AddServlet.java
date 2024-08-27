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

@WebServlet(name = "ProductAddServlet", urlPatterns = "/product_add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        ArrayList<Categories> categories = categoriesDAO.list();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/product/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String categoryId = req.getParameter("category_id");
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setName(name);
        product.setPrice(Float.parseFloat(price));
        product.setCategoryId(Integer.parseInt(categoryId));
        productDAO.add(product);
        resp.sendRedirect(req.getContextPath() + "/product");
    }
}
