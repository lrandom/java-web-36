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

@WebServlet(name = "ProductUpdateServlet", urlPatterns = "/product_edit")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.get(id);
        req.setAttribute("product", product);

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        req.setAttribute("categories", categoriesDAO.list());
        req.getRequestDispatcher("/WEB-INF/views/product/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String categoryId = req.getParameter("category_id");
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.setCategoryId(Integer.parseInt(categoryId));
        productDAO.update(id, product);
        resp.sendRedirect(req.getContextPath() + "/product");
    }
}
