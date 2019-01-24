package com.codecool.shop.personal;

public class ContactInfo {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Address billingAddress;
    private Address shippingAddress;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBillingAddressString() {
        return this.billingAddress.toString();
    }


    public String getShippingAddressString() {
        return this.shippingAddress.toString();
    }

    public ContactInfo(String name, String email, String phoneNumber, Address billingAddress, Address shippingAddress) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

    public ContactInfo(int id, String name, String email, String phoneNumber, Address billingAddress, Address shippingAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
}
