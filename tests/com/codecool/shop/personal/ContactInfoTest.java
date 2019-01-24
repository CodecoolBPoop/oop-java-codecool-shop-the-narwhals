package com.codecool.shop.personal;

import static org.junit.jupiter.api.Assertions.*;

class ContactInfoTest {

    @org.junit.jupiter.api.Test
    void getBillingAddressString() {
        Address address = new Address("address", "city", "country", "zip");
        ContactInfo sampleInfo = new ContactInfo("dori", "narwhal@dzsimejl.com", "01234567", address, address);
        assertEquals("", sampleInfo.toString());
    }

    @org.junit.jupiter.api.Test
    void getShippingAddressString() {
    }
}