module com.example.prince_018_lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prince_018_lab4 to javafx.fxml;
    exports com.example.prince_018_lab4;
}