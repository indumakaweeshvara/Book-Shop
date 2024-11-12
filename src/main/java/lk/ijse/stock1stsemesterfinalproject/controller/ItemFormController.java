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

public class ItemFormController {

    @FXML
    private AnchorPane Apaneitem;

    @FXML
    private ComboBox<?> OrderIdComboItem;

    @FXML
    private TableColumn<?, ?> colCiditrm;

    @FXML
    private TableColumn<?, ?> colOrderIdItem;

    @FXML
    private TableColumn<?, ?> colqtyitem;

    @FXML
    private Button ibtnD;

    @FXML
    private Button ibtnR;

    @FXML
    private Button ibtnS;

    @FXML
    private Button ibtnU;

    @FXML
    private Label iemlblQty;

    @FXML
    private TableColumn<?, ?> itemcolname;

    @FXML
    private TableColumn<?, ?> itemcolprice;

    @FXML
    private Label itemidlbl;

    @FXML
    private Label itemlblname;

    @FXML
    private Label itemlbprice;

    @FXML
    private TableView<?> itemtbl;

    @FXML
    private Label lblItem;

    @FXML
    private Label lblOrderIdItem;

    @FXML
    private TextField txritem;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtprice;

    @FXML
    void ItemMouseOnClicked(MouseEvent event) {

    }

    @FXML
    void OrderIdComboItemOnAction(ActionEvent event) {

    }

    @FXML
    void iResetOnAction(ActionEvent event) {

    }

    @FXML
    void iSaveOnAction(ActionEvent event) {

    }

    @FXML
    void ideleteOnAction(ActionEvent event) {

    }

    @FXML
    void iupdateOnAction(ActionEvent event) {

    }

}
