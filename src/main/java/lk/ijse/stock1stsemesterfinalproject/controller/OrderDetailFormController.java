package lk.ijse.stock1stsemesterfinalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OrderDetailFormController {

    @FXML
    private AnchorPane ApaneLOD;

    @FXML
    private Label ODID;

    @FXML
    private Button btnDOD;

    @FXML
    private Button btnROD;

    @FXML
    private Button btnSOD;

    @FXML
    private Button btnUOD;

    @FXML
    private ComboBox<?> comboODID;

    @FXML
    private ComboBox<?> comboODItemID;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblblidOD;

    @FXML
    private TableView<?> tblOD;

    @FXML
    private TextField txtAmount;

    @FXML
    void ODResetOnAction(ActionEvent event) {

    }

    @FXML
    void ODSaveOnAction(ActionEvent event) {

    }

    @FXML
    void ODdeleteOnAction(ActionEvent event) {

    }

    @FXML
    void ODupdateOnAction(ActionEvent event) {

    }

}
