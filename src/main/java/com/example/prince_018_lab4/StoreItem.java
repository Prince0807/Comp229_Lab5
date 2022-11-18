// PRINCE KIRITKUMAR PATEL
// 301277354

package com.example.prince_018_lab4;

public class StoreItem {

    ////////////////
    // Attributes //
    ////////////////
    private String name;
    private float price;
    private int quantity;

    /////////////////
    // Constructor //
    /////////////////
    StoreItem(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    ///////////////////////
    // Getters & Setters //
    ///////////////////////
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
