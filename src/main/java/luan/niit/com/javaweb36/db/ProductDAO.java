package luan.niit.com.javaweb36.db;

import luan.niit.com.javaweb36.models.Categories;
import luan.niit.com.javaweb36.models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO extends DB implements IDAO<Product> {
    public ProductDAO() {
        getConnect();
    }

    @Override
    public ArrayList<Product> list() {
        try {
            ArrayList<Product> list = new ArrayList<>();
            String sql = "SELECT * FROM products";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("category_id"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product get(int id) {
        try {
            String sql = "SELECT * FROM products WHERE id = " + id;
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                return product;
            }
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public boolean remove(int id) {
        try {
            String sql = "DELETE FROM products WHERE id = " + id;
            connection.createStatement().executeUpdate(sql);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Product update(int id, Product newProduct) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET name = ? WHERE id = ?");
            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            //đối tượng sau khi update
            return get(id);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Product add(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products(name,price,category_id) VALUES (?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCategoryId());
            preparedStatement.executeUpdate();
            return get(getLastId());
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public int getLastId() {
        return 0;
    }
}
