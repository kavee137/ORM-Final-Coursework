package lk.ijse.controller;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.*;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StudentDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AnalyticsDashboard {


    @FXML
    private PieChart pieChart2;

    @FXML
    private PieChart pieChart;

    @FXML
    private Label lblProgramCount;

    @FXML
    private Label lblRegCount;

    @FXML
    private Label lblStudentCount;

    @FXML
    private Label lblStudentCount21;

    @FXML
    private Label lblTransactionsCount;

    @FXML
    private AnchorPane rootNode;


    StudentBO studentBO  = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    ProgramBO programBO  = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PROGRAM);
    RegistrationBO registrationBO  = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);
    PaymentBO paymentBO  = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);
    DashboardBO dashboardBO  = (DashboardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.DASHBOARD);



    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        loadStudentCount();
        loadProgramCount();
        loadRegistrationCount();
        loadSumOfTransactionsAmount();
        setPieChart1();
        setPieChart2();

    }



    String studentCount = null;
    String programCount = null;
    String regCount = null;


    private void setPieChart1() {

            // Convert text to numbers
            int studentCountValue = Integer.parseInt(studentCount);
            int programCountValue = Integer.parseInt(programCount);
            int regCountValue = Integer.parseInt(regCount);

            // Create PieChart data
            PieChart.Data studentData = new PieChart.Data("Students " + "(" + studentCountValue + ")", studentCountValue);
            PieChart.Data programData = new PieChart.Data("Programs " + "(" + programCountValue + ")", programCountValue);
            PieChart.Data regData = new PieChart.Data("Registrations " + "(" + regCountValue + ")", regCountValue);

            // Add data to the PieChart
            pieChart.setData(FXCollections.observableArrayList(studentData, programData, regData));

    }


    private void setPieChart2() {
        try {
            // Get the data from the business logic
            List<Object[]> resultSet = dashboardBO.getPieChart2Details();

            // Clear any existing data in the pie chart
            pieChart2.getData().clear();

            if (resultSet != null) {
                // Iterate over the result set and add PieChart.Data objects
                for (Object[] row : resultSet) {
                    String programName = (String) row[1] + " (" + ((Long) row[2]).intValue() + ")"; // Program Name with count
                    int studentCount = ((Long) row[2]).intValue(); // Count of students

                    // Create PieChart.Data object and add it to the PieChart's data list
                    pieChart2.getData().add(new PieChart.Data(programName, studentCount));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





















    private void loadStudentCount() throws SQLException, ClassNotFoundException {
        studentCount = studentBO.getStudentCount();
        lblStudentCount.setText(studentCount);
    }

    private void loadProgramCount() throws SQLException, ClassNotFoundException {
        programCount = programBO.getProgramCount();
        lblProgramCount.setText(programCount);
    }

    private void loadRegistrationCount() throws SQLException, ClassNotFoundException {
        regCount = registrationBO.getRegistrationCount();
        lblRegCount.setText(regCount);
    }

    private void loadSumOfTransactionsAmount() throws SQLException, ClassNotFoundException {
        lblTransactionsCount.setText(paymentBO.getSumOfTransactionsAmount());
    }

}
