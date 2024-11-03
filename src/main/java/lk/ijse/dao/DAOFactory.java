package lk.ijse.dao;

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
        STUDENT,ITEM,USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case USER:
                return new UserDAOImpl();

                default:
                return null;
        }
    }

}
