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

@WebServlet(name = "DeleteServlet", urlPatterns = "/categories_delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //lấy id từ trên url
        int id = Integer.parseInt(req.getParameter("id"));

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        categoriesDAO.remove(id);

        //chuyển hướng về trang danh sách
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}

