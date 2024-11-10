package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PaymentFormController {

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colPaymentDate;

    @FXML
    private TableColumn<?, ?> colPaymentId;

    @FXML
    private TableColumn<?, ?> colPaymentMethod;

    @FXML
    private TableColumn<?, ?> colRegistrationId;

    @FXML
    private Label lblPaidAmount;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblPaymentId1;

    @FXML
    private Label lblProgramFee;

    @FXML
    private Label lblProgramName;

    @FXML
    private Label lblRegId;

    @FXML
    private Label lblStudentId;

    @FXML
    private TableView<?> tblPayment;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtRegSearch;

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void idKeyReleaseAction(KeyEvent event) {

    }

    @FXML
    void nameKeyRelaseAction(KeyEvent event) {

    }

}
