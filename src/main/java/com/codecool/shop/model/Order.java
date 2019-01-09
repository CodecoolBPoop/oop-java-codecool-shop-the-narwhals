package com.codecool.shop.model;


import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Order extends BaseModel{
    private int id;
    private List<LineItem> items = new ArrayList<>();
    private int totalSum;

    private final String CURRENCY = "Credits";
    private Currency defaultCurrency;

    public Order(Product product, String orderName, String orderDescription) {
        super(orderName, orderDescription);
        setDefaultCurrency(Currency.getInstance(CURRENCY));
        addProduct(product);
        totalSum += product.getDefaultPrice();
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
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

    private LineItem getLineItemByProductId(int productId) {
        return items.stream()
                                    .filter(item -> item.getProductId() == productId)
                                    .findFirst()
                                    .orElse(null);
    }
}
