package com.view;

import java.net.URL;
import java.util.ResourceBundle;
import data.model.InventoryManagement;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private Button btnFindAverage;

    @FXML
    private Button btnGroup;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnShowInventory;

    @FXML
    private Button btnSort;

    @FXML
    private TextArea txaResults;
    private InventoryManagement inventoryManagement;



    @FXML
    void btnFindAverageOnClick(ActionEvent event) {
        txaResults.setText("");
        txaResults.appendText(String.format("Average price: %.2f", inventoryManagement.averagePrice()));
    }

    @FXML
    void btnGroupOnClick(ActionEvent event) {
        txaResults.setText("");
        String result = inventoryManagement.findLargestPricePerCategory();
        txaResults.appendText(String.format("The largest price per categories:\n%s", result));
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnShowInventoryOnClick(ActionEvent event) {
        txaResults.setText("");
        txaResults.appendText(inventoryManagement.showInventory());
    }

    @FXML
    void btnSortOnClick(ActionEvent event) {
        txaResults.setText("");
        String result = inventoryManagement.sortInventoryTypeAndID().toString();
        txaResults.appendText(result);
    }

    @FXML
    void initialize() {
        assert btnFindAverage != null : "fx:id=\"btnFindAverage\" was not injected: check your FXML file 'view-products.fxml'.";
        assert btnGroup != null : "fx:id=\"btnGroup\" was not injected: check your FXML file 'view-products.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'view-products.fxml'.";
        assert btnShowInventory != null : "fx:id=\"btnShowInventory\" was not injected: check your FXML file 'view-products.fxml'.";
        assert btnSort != null : "fx:id=\"btnSort\" was not injected: check your FXML file 'view-products.fxml'.";

    }
}

