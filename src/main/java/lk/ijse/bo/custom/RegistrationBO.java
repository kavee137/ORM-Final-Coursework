package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

import java.sql.SQLException;

public interface RegistrationBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException;

}
