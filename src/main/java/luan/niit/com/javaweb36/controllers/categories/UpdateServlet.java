package luan.niit.com.javaweb36.controllers.categories;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.db.CategoriesDAO;
import luan.niit.com.javaweb36.models.Categories;

import java.io.IOException;

@WebServlet(name = "CategoriesEditServlet", urlPatterns = "/categories_edit")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        Categories categories = categoriesDAO.get(id);
        req.setAttribute("category", categories);
        req.getRequestDispatcher("/WEB-INF/views/categories/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        Categories categories = new Categories();
        categories.setId(id);
        categories.setName(name);
        categoriesDAO.update(id,categories);
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}
