package lk.ijse.stock1stsemesterfinalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PaymentFormController {

    @FXML
    private AnchorPane ApanePayment;

    @FXML
    private Button btnDPayment;

    @FXML
    private Button btnRPayment;

    @FXML
    private Button btnSPayment;

    @FXML
    private Button btnUPayment;

    @FXML
    private TableColumn<?, ?> colAmountPayment;

    @FXML
    private TableColumn<?, ?> colOidPaymnt;

    @FXML
    private TableColumn<?, ?> colPaymentDate;

    @FXML
    private TableColumn<?, ?> colcontactPayment;

    @FXML
    private TableColumn<?, ?> colpaymentId;

    @FXML
    private ComboBox<?> combouIDPayment;

    @FXML
    private Label labelcontactPayment;

    @FXML
    private Label lblPayment;

    @FXML
    private Label lblPaymentDate;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblPaymontAmount;

    @FXML
    private Label lblidPayment;

    @FXML
    private TableView<?> tblPayment;

    @FXML
    private TextField txtAmountPayment;

    @FXML
    private TextField txtPaymentDate;

    @FXML
    private TextField txtcontactPayment;

    @FXML
    void ResetOnActionPayment(ActionEvent event) {

    }

    @FXML
    void SaveOnActionPayment(ActionEvent event) {

    }

    @FXML
    void deleteOnActionPayment(ActionEvent event) {

    }

    @FXML
    void updateOnActionPayment(ActionEvent event) {

    }

}
