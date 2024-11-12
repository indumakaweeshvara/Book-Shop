package lk.ijse.stock1stsemesterfinalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SupplierOrderDetailFormController {

    @FXML
    private AnchorPane Apane;

    @FXML
    private Button btnD;

    @FXML
    private Button btnR;

    @FXML
    private Button btnS;

    @FXML
    private Button btnU;

    @FXML
    private TableColumn<?, ?> colCid;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colUid;

    @FXML
    private Label labelcontact;

    @FXML
    private Label lbl;

    @FXML
    private TableView<?> tbl;

    @FXML
    private TextField txtcontact;

    @FXML
    void ResetOnAction(ActionEvent event) {

    }

    @FXML
    void SaveOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

}
