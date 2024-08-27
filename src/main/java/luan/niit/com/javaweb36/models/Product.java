package luan.niit.com.javaweb36.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private int id;
    private String name;
    private float price;
    private int categoryId;
    private String categoryName;
    private String path;

    public static void main(String[] args) {
        Product product = new Product();
    }
}
