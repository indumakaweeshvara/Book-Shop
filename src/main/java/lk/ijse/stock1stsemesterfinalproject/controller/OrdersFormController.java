package lk.ijse.stock1stsemesterfinalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class OrdersFormController {

    @FXML
    private Label CustIdlblOrder;

    @FXML
    private Label OLbl;

    @FXML
    private AnchorPane OrderApane;

    @FXML
    private TableView<?> OrderTbl;

    @FXML
    private TableColumn<?, ?> colCustIdOrder;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colOrderQty;

    @FXML
    private ComboBox<?> custIdComboOrder;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblOrderQty;

    @FXML
    private TableColumn<?, ?> orderIDcol;

    @FXML
    private Label orderIdLbl;

    @FXML
    private Button orderbtnD;

    @FXML
    private Button orderbtnR;

    @FXML
    private Button orderbtnS;

    @FXML
    private Button orderbtnU;

    @FXML
    private TextField txtOrderDesc;

    @FXML
    private TextField txtOrderQty;

    @FXML
    void OrderResetOnAction(ActionEvent event) {

    }

    @FXML
    void OrderSaveOnAction(ActionEvent event) {

    }

    @FXML
    void OrderTblOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void OrderdeleteOnAction(ActionEvent event) {

    }

    @FXML
    void OrderupdateOnAction(ActionEvent event) {

    }

    @FXML
    void custIdComboOrderOnAction(ActionEvent event) {

    }

}
