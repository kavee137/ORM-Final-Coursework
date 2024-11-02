package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        try {
            // Load the dashboard
            FXMLLoader customerLoader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
            Parent customerRoot = customerLoader.load();
            rootNode.getChildren().clear();
            rootNode.getChildren().add(customerRoot);

            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setTitle("Dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) {

    }

}
