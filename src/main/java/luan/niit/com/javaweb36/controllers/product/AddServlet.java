package luan.niit.com.javaweb36.controllers.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.db.CategoriesDAO;
import luan.niit.com.javaweb36.models.Categories;

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
        resp.sendRedirect(req.getContextPath() + "/product");
    }
}
