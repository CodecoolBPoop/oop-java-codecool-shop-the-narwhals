package com.codecool.shop.personal;

public class ContactInfo {
    private String name;
    private String email;
    private String phoneNumber;
    private Address billingAddress;
    private Address shippingAddress;

    public ContactInfo(String name, String email, String phoneNumber, Address billingAddress, Address shippingAddress) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
}
