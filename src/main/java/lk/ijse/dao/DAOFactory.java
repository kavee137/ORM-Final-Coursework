package lk.ijse.dao;

import lk.ijse.bo.custom.impl.PaymentBOImpl;
import lk.ijse.dao.custom.impl.*;
import lk.ijse.entity.Student;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT,ITEM,USER,LOGIN,PROGRAM,REGISTRATION,PAYMENT,QUERY,DASHBOARD
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case USER:
                return new UserDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case DASHBOARD:
                return new DashboardDAOImpl();
            default:
                return null;
        }
    }

}
