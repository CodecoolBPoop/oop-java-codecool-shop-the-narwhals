package com.codecool.shop.model;

public class LineItem extends BaseModel {
    private int productId;

    private int numberOfProducts;

    private float totalPrice;
    public LineItem(Product product, String name, String description) {
        super(name, description);
        numberOfProducts = 1;
        this.productId = product.getId();
        this.totalPrice = product.getDefaultPrice();
    }

    public int getProductId() {
        return productId;
    }

    public int getNumberOfLineItemProducts() {
        return numberOfProducts;
    }

    public void add(Product product) {
        numberOfProducts ++;
        totalPrice += product.getDefaultPrice();
    }

    public void remove(Product product) {
        numberOfProducts --;
        totalPrice -= product.getDefaultPrice();
    }

    public boolean isEmpty() {
        if (numberOfProducts < 1) {
            return true;
        } else {
            return false;
        }
    }
}
