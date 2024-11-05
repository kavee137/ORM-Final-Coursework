package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.entity.UserSession;
import lk.ijse.tdm.StudentTm;
import lk.ijse.tdm.UserTm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colRegisterDate;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblId;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<StudentTm> tblStudent;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private JFXButton btnStudentDelete;

    @FXML
    private JFXButton btnStudentSave;

    @FXML
    private JFXButton btnStudentUpdate;

    // system ekata log wechcha kenage userID eka
    int userID = UserSession.getInstance().getUserId();

    StudentBO studentBO  = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);



    public void initialize() {
        lblDate.setText(LocalDate.now().toString());
        generateNewStudentID();
        buttonsDisableAndEnable();
        loadAllUsers();
    }
    private void loadAllUsers() {
        tblStudent.getItems().clear();
        try {
            /*Get all Students*/
            ArrayList<StudentDTO> allStudents = studentBO.getAllStudents();

            for (StudentDTO studentDTO : allStudents) {
                int userId = studentDTO.getUser() != 0 ? studentDTO.getUser() : 0; // Or any default value you prefer
                tblStudent.getItems().add(new StudentTm(
                        studentDTO.getStudentId(),
                        studentDTO.getName(),
                        studentDTO.getAddress(),
                        studentDTO.getPhone(),
                        studentDTO.getRegDate(),
                        userId
                ));


            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }






    void buttonsDisableAndEnable() {
        btnStudentUpdate.setDisable(true);
        btnStudentSave.setDisable(false);
        btnStudentDelete.setDisable(true);
    }

    private void generateNewStudentID() {
        try {
            String nextStudentId = studentBO.generateNewID();

            lblId.setText(String.valueOf(nextStudentId));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }












    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }
    void clearFields() {
        txtName.setText(null);
        txtName.setStyle("");

        txtAddress.setText(null);
        txtAddress.setStyle("");

        txtPhoneNumber.setText(null);
        txtPhoneNumber.setStyle("");

        txtID.setText(null);
        txtID.setStyle("");

        generateNewStudentID();
        initialize();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        int id = Integer.parseInt(lblId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtPhoneNumber.getText();
        Date date = Date.valueOf(lblDate.getText());

        if (name.isEmpty() || address.isEmpty() || tel.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all fields").show();
            return;
        }

        try (Session session = SessionFactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();

            // Retrieve the User object from the database
            int userID = UserSession.getInstance().getUserId();
            User user = session.get(User.class, userID);
            System.out.println(userID);

            // Check if user was found in the database
            if (user == null) {
                new Alert(Alert.AlertType.ERROR, "User not found in the database").show();
                return;
            }

            // Create a new StudentDTO with the fetched User object
            StudentDTO studentDTO = new StudentDTO(id, name, address, tel, date, user.getUserId());

            // Save the StudentDTO
            boolean isSaved = studentBO.saveStudent(studentDTO);
            if (isSaved) {
                transaction.commit();
                new Alert(Alert.AlertType.CONFIRMATION, "Student saved!").show();
                clearFields();
                initialize();
            } else {
                transaction.rollback();
                new Alert(Alert.AlertType.ERROR, "Failed to save the student").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        int id = Integer.parseInt(lblId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtPhoneNumber.getText();

        StudentDTO studentDTO = new StudentDTO(id, name, address, tel);

        if (name.isEmpty() || address.isEmpty() || tel.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Fields cannot be empty!").show();
        } else {
            try {
                boolean isUpdated = studentBO.updateStudent(studentDTO);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Student updated!").show();
                    clearFields();
                    initialize();
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

}
