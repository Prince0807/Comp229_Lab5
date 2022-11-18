// PRINCE KIRITKUMAR PATEL
// 301277354

package com.example.prince_018_lab4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InvoiceController {

    ///////////////
    // Variables //
    ///////////////
    private float orderSum = 0f;

    //////////////
    // FXML IDs //
    //////////////
    @FXML
    private Label customerName, customerAddress, customerPhone;
    @FXML
    private Label itemNames, itemQuantities, itemPrices, itemTotals;
    @FXML
    private Label orderTotal, tax, shipping, amountToPay;

    //////////////////
    // FXML Methods //
    //////////////////

    // Constructor
    @FXML
    public void initialize() {
        customerName.setText(ShoppingCart.getCustomerName());
        customerAddress.setText(ShoppingCart.getCustomerAddress());
        customerPhone.setText(ShoppingCart.getCustomerPhone());

        for (StoreItem item : ShoppingCart.items) {
            itemNames.setText(itemNames.getText() + item.getName() + "\n");
            itemPrices.setText(itemPrices.getText() + "$" + item.getPrice() + "\n");
            itemQuantities.setText(itemQuantities.getText() + item.getQuantity() + "\n");
            itemTotals.setText(itemTotals.getText() + "$" + (item.getQuantity() * item.getPrice()) + "\n");

            orderSum += (item.getQuantity() * item.getPrice());
        }

        orderTotal.setText("$" + orderSum);
        tax.setText("$" + (orderSum * 0.1f));
        shipping.setText(ShoppingCart.isIsDeliverySelected() ? "$5.00" : "$0.00");
        amountToPay.setText("$" + ((orderSum * 1.1f) + (ShoppingCart.isIsDeliverySelected() ? 5f : 0f)));
    }

    // Return to main scene
    @FXML
    public void returnToHome(ActionEvent event) throws IOException {
        ShoppingCart.clearCart();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("grocery-order-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}