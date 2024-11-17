package lk.ijse.Bookshop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bookshop.dto.OrderDTO;
import lk.ijse.Bookshop.dto.PaymentDTO;
import lk.ijse.Bookshop.dto.tm.OrderTM;
import lk.ijse.Bookshop.dto.tm.PaymentTM;
import lk.ijse.Bookshop.model.OrderModel;
import lk.ijse.Bookshop.model.PaymentModel;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentFormController implements Initializable {

    @FXML
    private AnchorPane ApanePayment;

    @FXML
    private Button btnRPayment;

    @FXML
    private TableColumn<PaymentTM, Double> colAmountPayment;

    @FXML
    private TableColumn<OrderTM, String> colOidPaymnt;

    @FXML
    private TableColumn<PaymentTM, LocalDate> colPaymentDate;

    @FXML
    private TableColumn<PaymentTM, Integer> colcontactPayment;

    @FXML
    private TableColumn<PaymentTM, String> colpaymentId;

    @FXML
    private ComboBox<String> combouIDPayment;

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
    private TableView<PaymentTM> tblPayment;

    @FXML
    private TextField txtAmountPayment;

    @FXML
    private TextField txtPaymentDate;

    @FXML
    private TextField txtcontactPayment;

    PaymentModel paymentModel = new PaymentModel();

    OrderModel orderModel = new OrderModel();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        colpaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colAmountPayment.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        colcontactPayment.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colPaymentDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colOidPaymnt.setCellValueFactory(new PropertyValueFactory<>("orderId"));


        try {
            loadOrderIds();
            refreshPage();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void refreshPage() throws SQLException {
        refreshTable();

        String nextPaymentId = paymentModel.getNextPaymentId();
        lblPaymentId.setText(nextPaymentId);

        txtAmountPayment.setText("");
        txtcontactPayment.setText("");
        txtPaymentDate.setText("");

    }

    private void refreshTable() throws SQLException {
        ArrayList<PaymentDTO> paymentDTOS = paymentModel.getAllPayment();
        ObservableList<PaymentTM> paymentTMS = FXCollections.observableArrayList();

        for (PaymentDTO paymentDTO : paymentDTOS) {
            PaymentTM paymentTM = new PaymentTM(
                    paymentDTO.getPaymentId(),
                    paymentDTO.getAmount(),
                    paymentDTO.getContact(),
                    paymentDTO.getPaymentDate(),
                    paymentDTO.getOrderId()
                    );
            paymentTMS.add(paymentTM);
        }
        tblPayment.setItems(paymentTMS);
    }

    private void loadOrderIds() throws SQLException {
        ArrayList<String> orderIds = orderModel.getAllOrderIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(orderIds);
        combouIDPayment.setItems(observableList);
    }

    @FXML
    void combouIDPaymentOnAction(ActionEvent event) throws SQLException {
        String selectedOrderId = combouIDPayment.getSelectionModel().getSelectedItem();
        if (selectedOrderId != null) {
            OrderDTO orderDTO = orderModel.findById(selectedOrderId);
        }
    }

    @FXML
    void ResetOnActionPayment(ActionEvent event) throws SQLException {
        combouIDPayment.setValue(null);
        combouIDPayment.setPromptText("Select order Id");

        refreshPage();
    }

    @FXML
    void onClickedTable(MouseEvent event) {
        PaymentTM selectedItem = tblPayment.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblPaymentId.setText(selectedItem.getPaymentId());
            txtAmountPayment.setText(String.valueOf(selectedItem.getAmount()));
            txtcontactPayment.setText(String.valueOf(selectedItem.getContact()));
            txtPaymentDate.setText(String.valueOf(selectedItem.getPaymentDate()));
            combouIDPayment.setValue(selectedItem.getOrderId());

        }
    }
}
