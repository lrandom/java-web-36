package luan.niit.com.javaweb36.db;

import luan.niit.com.javaweb36.models.Categories;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriesDAO extends DB {
    public CategoriesDAO() {
        //open connection to database
        getConnect();
    }

    public ArrayList<Categories> list() {
        try {
            ArrayList<Categories> list = new ArrayList<>();
            String sql = "SELECT * FROM categories";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                Categories categories = new Categories();
                categories.setId(rs.getInt("id"));
                categories.setName(rs.getString("name"));
                list.add(categories);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public Categories get(int id) {
        try {
            String sql = "SELECT * FROM categories WHERE id = " + id;
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if (rs.next()) {
                Categories categories = new Categories();
                categories.setId(rs.getInt("id"));
                categories.setName(rs.getString("name"));
                return categories;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public boolean remove(int id) {
        try {
            String sql = "DELETE FROM categories WHERE id = " + id;
            connection.createStatement().executeUpdate(sql);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public Categories update(int id, Categories newCategories) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categories SET name = ? WHERE id = ?");
            preparedStatement.setString(1, newCategories.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            //đối tượng sau khi update
            return get(id);
        } catch (Exception e) {

        }
        return null;
    }

    public Categories add(Categories newCategories) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categories(name) VALUES (?)");
            preparedStatement.setString(1, newCategories.getName());
            preparedStatement.executeUpdate();
            return get(getLastId());
        } catch (Exception e) {

        }

        return null;
    }

    public int getLastId() {
        try {
            String sql = "SELECT MAX(id) as id FROM categories";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {

        }
        return 0;
    }
}
