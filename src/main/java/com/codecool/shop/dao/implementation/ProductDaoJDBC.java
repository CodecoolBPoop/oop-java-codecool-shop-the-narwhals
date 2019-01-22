package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.database.ShopDBCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJDBC implements ProductDao {
    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        String query = "SELECT * FROM product;";

        List<Product> resultList = new ArrayList<>();

        try(Connection connection = ShopDBCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Product product = new Product(resultSet.getString("name"),
                            resultSet.getFloat("default_price"),
                            resultSet.getString("currency_string"),
                            resultSet.getString("description"),
                        resultSet.getInt("product_category_id"),
                        resultSet.getInt("supplier_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }

    @Override
    public List<Product> getByComplex(int productCategoryId, int supplierId) {
        return null;
    }
}
