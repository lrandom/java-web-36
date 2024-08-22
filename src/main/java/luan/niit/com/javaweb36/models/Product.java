package luan.niit.com.javaweb36.models;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private double price;
    private int categoryId;
    private String categoryName;

    public static void main(String[] args) {
        Product product = new Product();
    }
}
