module exam.view {
    exports exam.view;
    requires javafx.controls;
    requires javafx.fxml;
    requires exam.logic;
    opens exam.view to javafx.fxml;
}