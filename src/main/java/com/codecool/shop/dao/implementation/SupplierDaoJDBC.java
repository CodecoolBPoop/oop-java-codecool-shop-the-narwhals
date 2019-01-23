package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.database.ShopDBCreator;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJDBC implements SupplierDao {

    private static SupplierDaoJDBC instance = null;

    public SupplierDaoJDBC() {

    }

    public static SupplierDaoJDBC getInstance() {
        if (instance == null) {
            instance = new SupplierDaoJDBC();
        }
        return instance;
    }

    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {
        String query = "SELECT * FROM supplier " +
                "WHERE id = " + id + ";";


        try(Connection connection = ShopDBCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
            resultSet.next();
            int supplierId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");

            Supplier supplier = new Supplier(supplierId, name, description);
            return supplier;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Supplier> getAll() {
        String query = "SELECT * FROM supplier;";

        List<Supplier> resultList = new ArrayList<>();

        try(Connection connection = ShopDBCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                int supplierId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Supplier supplier = new Supplier(supplierId, name, description);

                resultList.add(supplier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
