package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Registration;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.SQLException;

public interface RegistrationDAO extends CrudDAO<Registration> {

    public boolean saveRegistration(Registration registration, Session session) throws SQLException, ClassNotFoundException, IOException;

}
