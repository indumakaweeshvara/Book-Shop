package lk.ijse.Bookshop.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.Bookshop.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ForgetPasswordFormController {

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private ImageView imgBack;

    @FXML
    private Label lblLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private AnchorPane rootPane;

    public static String emailAddress = "";

    @FXML
    private Label lblError;

    private UserModel userModel = new UserModel();

    @FXML
    public void initialize() {
        txtEmail.requestFocus();
    }

    @FXML
    void btnSubmitOnAction(ActionEvent event) throws SQLException {
        if (areFieldsEmpty()) {
            showErrorMessage("*Required fields are empty");
        } else if (!isValidEmailAddress()) {
            showErrorMessage("*Invalid email address");
        } else {
            emailAddress = txtEmail.getText();
            loadUI("/view/otpForm.fxml");
        }
    }

    private boolean isValidEmailAddress() throws SQLException {
        return userModel.isEmailExists(txtEmail.getText());
    }

    private boolean areFieldsEmpty() {
        return txtEmail.getText().isEmpty();
    }

    @FXML
    void imgBackOnAction(MouseEvent event) {
        loadUI("/view/loginForm.fxml");
    }

    private void loadUI(String resource) {
        rootPane.getChildren().clear();
        try {
            rootPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(resource))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showErrorMessage(String message) {
        lblError.setText(message);
        lblError.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(2),
                ae -> lblError.setText("")
        ));
        timeline.play();
    }
}