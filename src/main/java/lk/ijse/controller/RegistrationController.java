package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Util.Regex;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.bo.custom.RegistrationBO;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistrationController {

    @FXML
    private JFXComboBox<String> cmbProgramName;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colPaidAmount;

    @FXML
    private TableColumn<?, ?> colProgramId;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private TableColumn<?, ?> colRegId;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblFee;

    @FXML
    private Label lblProgramDuration;

    @FXML
    private Label lblProgramId;

    @FXML
    private Label lblRegistrationId;

    @FXML
    private Label lblStudentName;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<?> tblRegistration;

    @FXML
    private TextField txtFirstPayment;

    @FXML
    private TextField txtStudentId;




    ProgramBO programBO  = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PROGRAM);
    RegistrationBO registrationBO  = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);
    StudentBO studentBO  = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize() {
        lblDate.setText(LocalDate.now().toString());
        setCmbProgramName();
        generateNewRegID();
    }

    private void generateNewRegID() {
        try {
            String nextRegId = registrationBO.generateNewID();

            lblRegistrationId.setText(String.valueOf(nextRegId));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }






    private void setCmbProgramName() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            obList.addAll(programBO.getProgramNames());
            cmbProgramName.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }











    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtStudentId.getText();

        if (!txtStudentId.getText().isEmpty()) {

            if (isSearchIdValied()) {
                Student student = studentBO.studentSearch(Integer.parseInt(id));
                if (student != null) {
                    lblStudentName.setText(student.getName());
                } else {
                    new Alert(Alert.AlertType.WARNING, "Student not found!").show();
                }
            } else {
                validationError();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Please enter a Student ID!").show();
        }
    }

    public boolean isSearchIdValied(){
        return Regex.setTextColor(lk.ijse.Util.TextField.INTID, txtStudentId);
    }


    private void validationError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText("Validation Failed");
        alert.setContentText("Please fill in all fields correctly.");
        alert.showAndWait();
    }










    @FXML
    void btnViewRegistrationDetailsOnAction(ActionEvent event) {

    }

    @FXML
    void cmbProgramNameOnAction(ActionEvent event) {
        String name = cmbProgramName.getValue();
        try {
            Program program = programBO.searchByName(name);

            if (program != null) {
                lblProgramId.setText(program.getProgramId());
                lblFee.setText(String.valueOf(program.getFee()));
                lblProgramDuration.setText(program.getDuration());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    void clearFields() {
        txtStudentId.setText(null);
        txtStudentId.setStyle("");

        lblStudentName.setText(null);
        lblStudentName.setStyle("");

        lblProgramDuration.setText(null);
        lblFee.setText(null);
        lblProgramId.setText(null);
        cmbProgramName.setValue(null);

        txtFirstPayment.setText(null);
        txtFirstPayment.setStyle("");

        tblRegistration.getItems().clear();

        initialize();
    }

    // regex for student id search

    public void idKeyReleaseAction(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.Util.TextField.INTID, txtStudentId);
    }

    public void paymentOnKeyReleaseOnAction(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.Util.TextField.PRICEDOT, txtFirstPayment);
    }
}
