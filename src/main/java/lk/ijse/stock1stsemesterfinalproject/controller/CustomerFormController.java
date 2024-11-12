package lk.ijse.stock1stsemesterfinalproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.stock1stsemesterfinalproject.dto.CustomerDTO;
import lk.ijse.stock1stsemesterfinalproject.dto.UserDTO;
import lk.ijse.stock1stsemesterfinalproject.dto.tm.CustomerTM;
import lk.ijse.stock1stsemesterfinalproject.dto.tm.UserTM;
import lk.ijse.stock1stsemesterfinalproject.model.CustomerModel;
import lk.ijse.stock1stsemesterfinalproject.model.UserModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

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
    private TableColumn<CustomerTM, String> colAddress;

    @FXML
    private TableColumn<CustomerTM, String> colCid;

    @FXML
    private TableColumn<CustomerTM, String> colName;

    @FXML
    private TableColumn<UserTM, String> colUid;

    @FXML
    private TableColumn<CustomerTM, Integer> colcontact;

    @FXML
    private ComboBox<String> combouID;

    @FXML
    private Label custidlbl;

    @FXML
    private Label labelcontact;

    @FXML
    private Label lbl;

    @FXML
    private Label lbladdress;

    @FXML
    private Label lblblid;

    @FXML
    private Label lblname;

    @FXML
    private TableView<CustomerTM> tbl;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcontact;

    @FXML
    private TextField txtcustname;

    CustomerModel customerModel = new CustomerModel();

    UserModel userModel = new UserModel();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCid.setCellValueFactory(new PropertyValueFactory<>("Cust_Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Cust_Name"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colUid.setCellValueFactory(new PropertyValueFactory<>("User_Id"));

        try {
            loadUserIds();
            refreshPage();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void refreshPage() throws SQLException {
        refreshTable();

        String nextCustomerID = customerModel.getNextCustomerId();
        lbl.setText(nextCustomerID);

        txtcustname.setText("");
        txtcontact.setText("");
        txtaddress.setText("");

        btnS.setDisable(false);
        btnD.setDisable(true);
        btnU.setDisable(true);
    }

    private void refreshTable() throws SQLException {
        ArrayList<CustomerDTO> customerDTOS = customerModel.getAllCustomers();
        ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();

        for (CustomerDTO customerDTO : customerDTOS) {
            CustomerTM customerTM = new CustomerTM(
                    customerDTO.getCust_Id(),
                    customerDTO.getCust_Name(),
                    customerDTO.getContact(),
                    customerDTO.getAddress(),
                    customerDTO.getUser_Id()
                    );
            customerTMS.add(customerTM);
        }
        tbl.setItems(customerTMS);
    }

    @FXML
    void ResetOnAction(ActionEvent event) throws SQLException {
        combouID.setValue(null);
        combouID.setPromptText("Select User_Id");
        refreshPage();
    }

    @FXML
    void SaveOnAction(ActionEvent event) throws SQLException {
        String Cust_Id = lbl.getText();
        String Cust_Name = txtcustname.getText();
        Integer Contact = Integer.valueOf(txtcontact.getText());
        String Address = txtaddress.getText();
        String User_Id = combouID.getValue();

        // Define regex patterns for validation
        String namePattern = "^[A-Za-z ]+$";
        String contactPattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
        String addressPattern = "^[\\d\\D\\s,.-]+$";

//        Validate each field using regex patterns
        boolean isValidName = Cust_Name.matches(namePattern);
        boolean isValidContact = String.valueOf(Contact).matches(String.valueOf(contactPattern));
        boolean isValidAddress = Address.matches(addressPattern);

        // Reset input field styles
        txtcustname.setStyle(txtcustname.getStyle() + ";-fx-border-color:  #091057;");
        txtcontact.setStyle(txtcontact.getStyle() + ";-fx-border-color: #091057;");
        txtaddress.setStyle(txtaddress.getStyle() + ";-fx-border-color:  #091057;");

        // Highlight invalid fields in red

        if (!isValidName) {
            txtcustname.setStyle(txtcustname.getStyle() + ";-fx-border-color: red;");
        }

        if (!isValidContact) {
            txtcontact.setStyle(txtcontact.getStyle() + ";-fx-border-color: red;");
        }

        if (!isValidAddress) {
            txtaddress.setStyle(txtaddress.getStyle() + ";-fx-border-color: red;");
        }

        // Save customer if all fields are valid
        if (isValidName && isValidContact && isValidAddress) {
            CustomerDTO customerDTO = new CustomerDTO(Cust_Id, Cust_Name, Contact, Address, User_Id);

            boolean isSaved = customerModel.saveCustomer(customerDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
                refreshPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to save customer...!").show();
            }
        }
    }

    @FXML
    void deleteOnAction(ActionEvent event) throws SQLException {
        String Cust_Id = lbl.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this customer?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {

            boolean isDeleted = customerModel.deleteCustomer(Cust_Id);

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
                refreshPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) throws SQLException {
        String Cust_Id = lbl.getText();
        String Cust_Name = txtcustname.getText();
        Integer Contact = Integer.valueOf(txtcontact.getText());
        String Address = txtaddress.getText();
        String User_Id = combouID.getValue();

        // Define regex patterns for validation
        String namePattern = "^[A-Za-z ]+$";
        String contactPattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
        String addressPattern = "^[\\d\\D\\s,.-]+$";

//        Validate each field using regex patterns
        boolean isValidName = Cust_Name.matches(namePattern);
        boolean isValidContact = String.valueOf(Contact).matches(String.valueOf(contactPattern));
        boolean isValidAddress = Address.matches(addressPattern);

        // Reset input field styles
        txtcustname.setStyle(txtcustname.getStyle() + ";-fx-border-color:  #091057;");
        txtcontact.setStyle(txtcontact.getStyle() + ";-fx-border-color: #091057;");
        txtaddress.setStyle(txtaddress.getStyle() + ";-fx-border-color:  #091057;");

        // Highlight invalid fields in red

        if (!isValidName) {
            txtcustname.setStyle(txtcustname.getStyle() + ";-fx-border-color: red;");
        }

        if (!isValidContact) {
            txtcontact.setStyle(txtcontact.getStyle() + ";-fx-border-color: red;");
        }

        if (!isValidAddress) {
            txtaddress.setStyle(txtaddress.getStyle() + ";-fx-border-color: red;");
        }

        // Save customer if all fields are valid
        if (isValidName && isValidContact && isValidAddress) {
            CustomerDTO customerDTO = new CustomerDTO(Cust_Id, Cust_Name, Contact, Address, User_Id);

            boolean isSaved = customerModel.updateCustomer(customerDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
                refreshPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to save customer...!").show();
            }
        }
    }

    @FXML
    void onClickedTable(MouseEvent event) {
        CustomerTM selectedItem = tbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lbl.setText(selectedItem.getCust_Id());

            txtcustname.setText(selectedItem.getCust_Name());
            txtcontact.setText(String.valueOf(selectedItem.getContact()));
            txtaddress.setText(selectedItem.getAddress());
            combouID.setValue(selectedItem.getUser_Id());

            btnS.setDisable(true);
            btnD.setDisable(false);
            btnU.setDisable(false);
        }
    }

    private void loadUserIds() throws SQLException {
        ArrayList<String> userIds = userModel.getAllUserIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(userIds);
        combouID.setItems(observableList);
    }

    @FXML
    void combouIDOnAction(ActionEvent event) throws SQLException {
        String selectedUserId = combouID.getSelectionModel().getSelectedItem();
        if (selectedUserId != null) {
            UserDTO userDTO = userModel.findById(selectedUserId);
        }
    }
}
