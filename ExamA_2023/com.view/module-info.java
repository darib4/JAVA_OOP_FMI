module com.view {
    exports com.view;
    requires javafx.controls;
    requires javafx.fxml;
    requires data.model;
    opens com.view to javafx.fxml;
}