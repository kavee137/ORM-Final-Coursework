package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegistrationBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RegistrationDAO;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAO registrationDAO = (RegistrationDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTRATION);

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return registrationDAO.generateNewID();
    }
}
