package luan.niit.com.javaweb36;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load jdbc driver
            //open connect to database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java36", "root", "koodinh@");
            String sql ="SELECT COUNT(id) AS total_rows FROM users WHERE email='" + email + "' AND password='" + password + "'";
            //COUNT(id)
            ResultSet resultSet= connection.createStatement().executeQuery(sql);//execute query
            if (resultSet.next()) {
                int count = resultSet.getInt("total_rows");//lấy về số bản ghi tương ứng với email và password nhập vào
                if (count > 0) {

                    resp.getWriter().write("Dang nhap thanh cong");
                } else {
                    resp.getWriter().write("Dang nhap that bai");
                }
            }
        } catch (Exception e) {

        }
    }
}
