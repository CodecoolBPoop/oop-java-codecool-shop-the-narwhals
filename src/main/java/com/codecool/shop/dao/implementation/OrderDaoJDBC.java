package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.database.ShopDBCreator;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.personal.ContactInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoJDBC implements OrderDao {
    private static OrderDaoJDBC instance = null;

    public OrderDaoJDBC() {

    }

    public static OrderDaoJDBC getInstance() {
        if (instance == null) {
            instance = new OrderDaoJDBC();
        }
        return instance;
    }

    public void add(ContactInfo contactInfo) {
        String contactInfoQuery = " INSERT INTO contact_info (name, email, phone_number, billing_address, " +
                " shipping_address)" +
                " VALUES (?,?,?,?,?);";

        try(Connection connection = ShopDBCreator.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(contactInfoQuery)

        ) {
            preparedStatement.setString(1, contactInfo.getName());
            preparedStatement.setString(2, contactInfo.getEmail());
            preparedStatement.setString(3, contactInfo.getPhoneNumber());
            preparedStatement.setString(4, contactInfo.getBillingAddressString());
            preparedStatement.setString(5, contactInfo.getShippingAddressString());


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(Order order) {


    }

    public void add(LineItem lineItem) {
        String lineItemQuery = " INSERT INTO line_item (id, number_of_products, product_id, order_info_id) VALUES (?,?,?,?);";
    }


    public List<LineItem> getLineItems(int orderId) {
        List<LineItem> lineItems = new ArrayList<>();

        String lineItemQuery = "SELECT * FROM line_item" +
                " WHERE order_info_id = " + orderId + ";";

        try (Connection connection = ShopDBCreator.getConnection();
             Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(lineItemQuery)
        ){
            while (resultSet.next()) {
                int lineItemId = resultSet.getInt("id");
                int numberOfProducts = resultSet.getInt("number_of_products");
                String lineItemName = resultSet.getString("name");
                String lineItemDescription = resultSet.getString("description");
                int productId = resultSet.getInt("product_id");

                ProductDaoJDBC productDataStore = ProductDaoJDBC.getInstance();
                Product product = productDataStore.find(productId);

                LineItem lineItem = new LineItem(product, lineItemId, numberOfProducts, lineItemName, lineItemDescription, productId);
                lineItems.add(lineItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineItems;
    }

    @Override
    public Order find(int orderId) {
        String orderQuery = "SELECT * FROM order_info" +
                " WHERE id = " + orderId + ";";

        try (Connection connection = ShopDBCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(orderQuery)
        ){
            resultSet.next();
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            int totalSum = resultSet.getInt("total_sum");
            String currency = resultSet.getString("currency");
            int contactInfoId = resultSet.getInt("contact_info_id");

            OrderDaoJDBC orderDataStore = OrderDaoJDBC.getInstance();
            List<LineItem> lineItems = orderDataStore.getLineItems(orderId);

            Order order = new Order()


            return order;
            } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public ContactInfo getContactInfo(int orderId) {
        String contactInfoQuery = "SELECT * FROM contact_info" +
                " WHERE order_info_id = " + orderId + ";";

        try (Connection connection = ShopDBCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(contactInfoQuery)
        ){
            resultSet.next();
            int contactInfoId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phoneNumber = resultSet.getString("phone_number");
            String billingAddress = resultSet.getString("billing_address");
            String shippingAddress = resultSet.getString("shipping_address");

            OrderDaoJDBC orderDataStore = OrderDaoJDBC.getInstance();
            ContactInfo contactInfo = new ContactInfo(contactInfoId, name, email, phoneNumber, billingAddress, shippingAddress);

            return contactInfo;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }



    @Override
    public void remove(int id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
