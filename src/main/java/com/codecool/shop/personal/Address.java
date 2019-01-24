package com.codecool.shop.personal;

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

    @Override
    public String toString() {
        return "Address{," +
                "address='" + address + '\'' +
                "; city='" + city + '\'' +
                "; country='" + country + '\'' +
                "; zipCode='" + zipCode + '\'' +
                ",}";
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
}
