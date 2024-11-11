package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.PaymentDTO;
import lk.ijse.dto.RegistrationDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface RegistrationBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException, IOException;

    boolean saveRegistration(RegistrationDTO registrationDTO, PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException, IOException;

}
