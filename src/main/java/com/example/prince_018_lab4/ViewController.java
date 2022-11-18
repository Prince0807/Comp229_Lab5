// PRINCE KIRITKUMAR PATEL
// 301277354

package com.example.prince_018_lab4;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewController {

    ///////////////
    // Variables //
    ///////////////
    ShoppingCart cart = new ShoppingCart();
    float[] prices = {6.98f, 11.99f, 6.49f, 2.25f, 3.29f};

    //////////////
    // FXML IDs //
    //////////////
    @FXML
    private ComboBox<String> item_name_cb, item_quantity_cb;
    @FXML
    private TextField customerNameTxt, customerPhoneTxt, customerAddressTxt;
    @FXML
    private RadioButton deliveryRB;
    @FXML
    private TextArea textArea;

    //////////////////
    // FXML Methods //
    //////////////////

    // Constructor
    @FXML
    public void initialize() {
        item_name_cb.setItems(FXCollections.observableArrayList("Choose item", "Apple", "Cheese", "Milk 2%", "Pepsi", "Yogurt"));
        item_quantity_cb.setItems(FXCollections.observableArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    }

    // Enable Quantities ComboBox only when an item is selected
    @FXML
    public void onActionItemNamesCB() {
        if (!item_name_cb.getSelectionModel().isSelected(0))
            item_quantity_cb.setDisable(false);
    }

    // Add item & quantities to cart, and then reset the items & quantities combobox.
    @FXML
    public void onActionAddtoCartBtn() {
        if (item_quantity_cb.getSelectionModel().isSelected(0))
            return;

        ShoppingCart.addItem(item_name_cb.getValue(), prices[item_name_cb.getSelectionModel().getSelectedIndex() - 1], Integer.parseInt(item_quantity_cb.getValue()));
        item_name_cb.getSelectionModel().select(0);
        item_quantity_cb.getSelectionModel().select(0);
        item_quantity_cb.setDisable(true);
        textArea.setText(cart.toString());
    }

    // On place order button click, open invoice scene
    @FXML
    public void onActionPlaceOrderBtn(ActionEvent event) throws IOException {
        ShoppingCart.setCustomerName(customerNameTxt.getText());
        ShoppingCart.setCustomerAddress(customerAddressTxt.getText());
        ShoppingCart.setCustomerPhone(customerPhoneTxt.getText());
        ShoppingCart.setIsDeliverySelected(deliveryRB.isSelected());

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("invoice.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}