package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Registration;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<Payment> {

    public boolean savePayment(Payment payment, Session session) throws SQLException, ClassNotFoundException, IOException;
}
