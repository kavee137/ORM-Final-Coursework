package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

import java.io.IOException;
import java.sql.SQLException;

public interface PaymentBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException, IOException;
}
