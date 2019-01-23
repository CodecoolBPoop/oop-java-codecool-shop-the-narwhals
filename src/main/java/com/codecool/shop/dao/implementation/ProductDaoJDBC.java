package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
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


    private static ProductDaoJDBC instance = null;
    public ProductDaoJDBC() {

    }

    public static ProductDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductDaoJDBC();
        }
        return instance;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        String query = "SELECT * FROM product " +
                "WHERE id = " + id + ";";

        try(Connection connection = ShopDBCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
            resultSet.next();
            int productId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Float defaultPrice = resultSet.getFloat("default_price");
            String currencyString = resultSet.getString("currency_string");
            String description = resultSet.getString("description");
            int productCategoryId = resultSet.getInt("product_category_id");
            int supplierId = resultSet.getInt("supplier_id");

            ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJDBC.getInstance();
            SupplierDao supplierDataStore = SupplierDaoJDBC.getInstance();

            ProductCategory productCategory = productCategoryDataStore.find(productCategoryId);
            Supplier supplier = supplierDataStore.find(supplierId);

            Product product = new Product(productId,    name, defaultPrice, description, currencyString, productCategory, supplier);
            return product;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Float defaultPrice = resultSet.getFloat("default_price");
                String currencyString = resultSet.getString("currency_string");
                String description = resultSet.getString("description");
                int productCategoryId = resultSet.getInt("product_category_id");
                int supplierId = resultSet.getInt("supplier_id");

                ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJDBC.getInstance();
                SupplierDao supplierDataStore = SupplierDaoJDBC.getInstance();

                ProductCategory productCategory = productCategoryDataStore.find(productCategoryId);
                Supplier supplier = supplierDataStore.find(supplierId);

                Product product = new Product(productId,    name, defaultPrice, description, currencyString, productCategory, supplier);
                resultList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;

    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        int currentSupplierId = supplier.getId();
        List<Product> resultList = new ArrayList<>();

        String query = "SELECT * FROM product" +
                " WHERE product.supplier_id = " + currentSupplierId + ";";

        try(Connection connection = ShopDBCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Float defaultPrice = resultSet.getFloat("default_price");
                String currencyString = resultSet.getString("currency_string");
                String description = resultSet.getString("description");
                int productCategoryId = resultSet.getInt("product_category_id");
                int supplierId = resultSet.getInt("supplier_id");

                ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJDBC.getInstance();
                ProductCategory productCategory = productCategoryDataStore.find(productCategoryId);

                Product product = new Product(productId, name, defaultPrice, description, currencyString, productCategory, supplier);
                resultList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;

    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        int currentProdCatId = productCategory.getId();
        List<Product> resultList = new ArrayList<>();

        String query = "SELECT * FROM product" +
                " WHERE product.product_category_id = " + currentProdCatId + ";";

        try(Connection connection = ShopDBCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Float defaultPrice = resultSet.getFloat("default_price");
                String currencyString = resultSet.getString("currency_string");
                String description = resultSet.getString("description");
                int supplierId = resultSet.getInt("supplier_id");

                SupplierDao supplierDataStore = SupplierDaoJDBC.getInstance();
                Supplier supplier = supplierDataStore.find(supplierId);

                Product product = new Product(productId, name, defaultPrice, description, currencyString, productCategory, supplier);
                resultList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;

    }

    @Override
    public List<Product> getByComplex(int productCategoryId, int supplierId) {

        List<Product> resultList = new ArrayList<>();

        String query = "SELECT * FROM product" +
                " WHERE product.product_category_id = " + productCategoryId +
                " AND product.supplier_id = " + supplierId + ";";

        try(Connection connection = ShopDBCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {
            int productId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Float defaultPrice = resultSet.getFloat("default_price");
            String currencyString = resultSet.getString("currency_string");
            String description = resultSet.getString("description");

            SupplierDao supplierDataStore = SupplierDaoJDBC.getInstance();
            ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJDBC.getInstance();

            Supplier supplier = supplierDataStore.find(supplierId);
            ProductCategory productCategory = productCategoryDataStore.find(productCategoryId);

            Product product = new Product(productId, name, defaultPrice, description, currencyString, productCategory, supplier);
            resultList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;

    }
}
