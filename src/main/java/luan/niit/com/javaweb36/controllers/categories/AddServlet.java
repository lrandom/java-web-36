package luan.niit.com.javaweb36.controllers.categories;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.db.CategoriesDAO;
import luan.niit.com.javaweb36.models.Categories;

import java.io.IOException;

@WebServlet(name = "CategoriesAddServlet", urlPatterns = "/categories_add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/categories/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        Categories categories = new Categories();
        categories.setName(name);
        categoriesDAO.add(categories);
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}
