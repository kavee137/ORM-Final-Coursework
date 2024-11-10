package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.RegistrationDAO;
import lk.ijse.entity.Registration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public ArrayList<Registration> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Registration entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Registration entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();

        try {
            // HQL query to fetch the latest registration id
            Query<Integer> query = session.createQuery("SELECT r.regId FROM Registration r ORDER BY r.regId DESC", Integer.class);
            query.setMaxResults(1); // Limit to get only the latest result

            Integer lastId = query.uniqueResult(); // Fetch the last registration

            // Check if lastId is null, which happens if there are no entries in the database
            if (lastId == null) {
                return String.valueOf(1); // Start from ID 1 if no registration exist
            } else {
                return String.valueOf(lastId + 1); // Increment the last ID by 1 if it exists
            }
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Registration search(Object... args) throws SQLException, ClassNotFoundException {
        return null;
    }
}
