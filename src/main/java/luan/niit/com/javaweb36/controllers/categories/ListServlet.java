package luan.niit.com.javaweb36.controllers.categories;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.niit.com.javaweb36.db.CategoriesDAO;
import luan.niit.com.javaweb36.models.Categories;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListServlet", urlPatterns = "/categories")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        ArrayList<Categories> categories = categoriesDAO.list();

        //set data vào trong request để gửi qua view
        req.setAttribute("categories", categories);
        for (Categories category : categories) {
            System.out.println("categories" + category.getName());
        }

        //tải cái trang jsp lên
        req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp").forward(req, resp);
    }
}
