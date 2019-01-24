package com.codecool.shop.model;

import com.codecool.shop.dao.implementation.ProductDaoJDBC;
import com.codecool.shop.dao.implementation.ProductDaoMem;

public class LineItem extends BaseModel {
    private int productId;
    private final float UNIT_PRICE;

    private int numberOfProducts;

    private float totalPrice;

    public LineItem(Product product, String name, String description) {
        super(name, description);
        numberOfProducts = 1;
        this.productId = product.getId();
        this.UNIT_PRICE = product.getDefaultPrice();
        this.totalPrice = product.getDefaultPrice();
    }

    public LineItem(Product product, int id, int numberOfProducts, String name, String description,int productId) {
        super(name, description);
        this.id = id;
        this.numberOfProducts = numberOfProducts;
        this.productId = productId;
        this.UNIT_PRICE = product.getDefaultPrice();
        this.totalPrice = product.getDefaultPrice();
    }

    public String getProductName() {
        ProductDaoJDBC productStore = ProductDaoJDBC.getInstance();
        return productStore.find(productId).getName();
    }

    public int getProductId() {
        return productId;
    }

    public int getNumberOfProducts() {
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

    public float getTotalPrice() {
        return totalPrice;
    }

    public float getUNIT_PRICE() {
        return UNIT_PRICE;
    }
}
