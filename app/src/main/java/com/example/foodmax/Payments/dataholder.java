package com.example.foodmax.Payments;

public class dataholder {
    String Name, Phone, Location, Address, City, FoodCode, Bill;

    public dataholder(String name, String phone, String location, String address, String city, String foodCode, String bill) {
        Name = name;
        Phone = phone;
        Location = location;
        Address = address;
        City = city;
        FoodCode = foodCode;
        Bill = bill;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getFoodCode() {
        return FoodCode;
    }

    public void setFoodCode(String foodCode) {
        FoodCode = foodCode;
    }

    public String getBill() {
        return Bill;
    }

    public void setBill(String bill) {
        Bill = bill;
    }
}

