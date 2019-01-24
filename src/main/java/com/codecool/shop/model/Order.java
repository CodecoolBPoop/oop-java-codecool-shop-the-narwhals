package com.codecool.shop.model;


import com.codecool.shop.personal.Address;
import com.codecool.shop.personal.ContactInfo;

import java.util.ArrayList;
import java.util.List;

public class Order extends BaseModel{
    private static Order instance = null;

    private List<LineItem> items = new ArrayList<>();
    private int totalSum;
    private final String CURRENCY = "Credits";

    private ContactInfo contactInfo;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public Order(String orderName, String orderDescription) {
        super(orderName, orderDescription);
    }

    public Order(int id, String name, String description, int totalSum, String currency, ContactInfo contactInfo, List<LineItem> lineItems) {
        super(name, description);
        this.id = id;
        this.totalSum = totalSum;
        this.contactInfo = contactInfo;
    }

    public static Order getInstance() {
        if (instance == null) {
            String orderName = "Current order";
            String description = "The only active order for now";
            instance = new Order(orderName, description);
        }
        return instance;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void addProduct(Product product) {
        LineItem lineItem = getLineItemByProductId(product.getId());
        if (lineItem == null) {
            String lineItemName = "Line item " + product.getName();
            String lineItemDescription = "Some " + product.getName() + "s";
            LineItem newLineItem = new LineItem(product, lineItemName, lineItemDescription);
            items.add(newLineItem);
        } else {
            lineItem.add(product);
        }
        totalSum += product.getDefaultPrice();
    }

    public void removeProduct(Product product) {
        LineItem lineItem = getLineItemByProductId(product.getId());
        lineItem.remove(product);
        totalSum -= product.getDefaultPrice();
        if (lineItem.isEmpty()) {
            items.remove(lineItem);
        }
    }

    public LineItem getLineItemByProductId(int productId) {
        return items.stream()
                    .filter(item -> item.getProductId() == productId)
                    .findFirst()
                    .orElse(null);
    }

    public int getTotalNumberOfOrderedProducts() {
        int numberOfOrderedProducts = 0;
        for (int i = 0; i < items.size(); i++) {
            numberOfOrderedProducts += items.get(i).getNumberOfProducts();
        }
        return numberOfOrderedProducts;
    }

    public float getTotalSum(){
        return totalSum;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: " + this.id + "," )
                .append("name: " + this.name + ",")
                .append("description: " + this.description + ",")
                .append("items: " + this.items + ",")
                .append("total sum: " + this.totalSum + ",")
                .append("currency: " + this.CURRENCY);
        return builder.toString();
    }

    public void addContactInfo(String name, String email, String phoneNumber, Address billingAddress, Address shippingAddress) {
        this.contactInfo = new ContactInfo(name, email, phoneNumber, billingAddress, shippingAddress);
    }

    public String getCurrency() {
        return CURRENCY;
    }

    public int getContactInfoId() {
        return contactInfo.getId();
    }

    public void setContactInfoId(int id) {
        contactInfo.setId(id);
    }
}
