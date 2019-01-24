package com.codecool.shop.personal;

import java.util.HashMap;
import java.util.Map;

public class Address {
    private String address;
    private String city;
    private String country;
    private String zipCode;

    public Address(String address, String city, String country, String zipCode) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Address(Map<String, String> addressFields) {
        this.address = addressFields.get("address");
        this.city = addressFields.get("city");
        this.country = addressFields.get("country");
        this.zipCode = addressFields.get("zipCode");
        //TODO: test if map has correct keys
    }



    @Override
    public String toString() {
        return "Address{;" +
                "address='" + address + '\'' +
                "; city='" + city + '\'' +
                "; country='" + country + '\'' +
                "; zipCode='" + zipCode + '\'' +
                ";}";
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public static Map<String, String> getAddressFields(String rawAddress) {
        String[] split = rawAddress.split(";");
        Map<String, String> result = new HashMap<>();
        result.put("address", split[1]);
        result.put("city", split[2]);
        result.put("country", split[3]);
        result.put("zipCode", split[4]);
        return result;
    }

}
