package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.LoginBO;
import lk.ijse.dto.LoginDTO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;


    LoginBO loginBO  = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGIN);


    public void initialize() {
        clickEnterButtonMoveCursor();
    }




    void clickEnterButtonMoveCursor() {
        txtUserName.setOnAction(event -> txtPassword.requestFocus());
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String userName= txtUserName.getText();
        String password = txtPassword.getText();

        try {
            LoginDTO loginDTO = new LoginDTO(userName, password);

            boolean loginResult = loginBO.checkCredential(loginDTO);
            if (loginResult) {

                navigateToTheDashboard((Stage) rootNode.getScene().getWindow());

            } else {
                // Show alert if credentials are incorrect
                new Alert(Alert.AlertType.ERROR, "Invalid credentials! Please try again.").show();
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void navigateToTheDashboard(Stage stage) throws IOException {
        // Load the dashboard
        FXMLLoader customerLoader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
        Parent customerRoot = customerLoader.load();
        rootNode.getChildren().clear();
        rootNode.getChildren().add(customerRoot);

        stage = (Stage) rootNode.getScene().getWindow();
        stage.setTitle("Dashboard");
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
