// PRINCE KIRITKUMAR PATEL
// 301277354

package com.example.prince_018_lab4;

import java.util.ArrayList;

public class ShoppingCart {

    //////////////////////
    // Static Variables //
    //////////////////////
    public static final ArrayList<StoreItem> items = new ArrayList<>();
    private static String customerName, customerAddress, customerPhone;
    private static boolean isDeliverySelected;


    ///////////////////////
    // Getters & Setters //
    ///////////////////////

    public static String getCustomerName() {
        return customerName;
    }

    public static void setCustomerName(String customerName) {
        ShoppingCart.customerName = customerName;
    }

    public static String getCustomerAddress() {
        return customerAddress;
    }

    public static void setCustomerAddress(String customerAddress) {
        ShoppingCart.customerAddress = customerAddress;
    }

    public static String getCustomerPhone() {
        return customerPhone;
    }

    public static void setCustomerPhone(String customerPhone) {
        ShoppingCart.customerPhone = customerPhone;
    }

    public static boolean isIsDeliverySelected() {
        return isDeliverySelected;
    }

    public static void setIsDeliverySelected(boolean isDeliverySelected) {
        ShoppingCart.isDeliverySelected = isDeliverySelected;
    }


    /////////////
    // Methods //
    /////////////

    // Add an item to arraylist of items
    public static void addItem(String itemName, float price, int quantity) {
        for (StoreItem item :
                items) {
            if (item.getName().equals(itemName)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new StoreItem(itemName, price, quantity));
    }

    public static void clearCart(){
        items.clear();
        setCustomerName("");
        setCustomerAddress("");
        setCustomerPhone("");
        isDeliverySelected = false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StoreItem item : items) {
            stringBuilder.append(item.getName()).append("\t(").append(item.getQuantity()).append(" x $")
                    .append(item.getPrice()).append(")\t: $").append(item.getQuantity() * item.getPrice()).append("\n");
        }
        return stringBuilder.toString();
    }
}
