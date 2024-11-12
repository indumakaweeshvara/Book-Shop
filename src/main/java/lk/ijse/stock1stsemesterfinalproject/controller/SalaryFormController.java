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

public class SalaryFormController {

    @FXML
    private AnchorPane Apane;

    @FXML
    private Button btnDSalary;

    @FXML
    private Button btnRSalary;

    @FXML
    private Button btnS;

    @FXML
    private Button btnUSalary;

    @FXML
    private TableColumn<?, ?> colAmountSalary;

    @FXML
    private TableColumn<?, ?> colDateSalary;

    @FXML
    private TableColumn<?, ?> colEmpIdSalary;

    @FXML
    private TableColumn<?, ?> colIdSalary;

    @FXML
    private ComboBox<?> comboEmpIdSalary;

    @FXML
    private Label lblEmpIdSalary;

    @FXML
    private Label lblSalaryAmount;

    @FXML
    private Label lblsalary;

    @FXML
    private Label salaryDatelbl;

    @FXML
    private Label salaryIDlbl;

    @FXML
    private TableView<?> tblSalary;

    @FXML
    private TextField txtAmountSalary;

    @FXML
    private TextField txtDateSalary;

    @FXML
    void ResetOnActionSalary(ActionEvent event) {

    }

    @FXML
    void SaveOnActionSalary(ActionEvent event) {

    }

    @FXML
    void deleteOnActionSalary(ActionEvent event) {

    }

    @FXML
    void updateOnActionSalary(ActionEvent event) {

    }

}
