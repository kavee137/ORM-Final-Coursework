package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;
import lk.ijse.entity.Student;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        STUDENT,USER,LOGIN,PROGRAM,REGISTRATION,PAYMENT,DASHBOARD
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl();
            case USER:
                return new UserBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case PROGRAM:
                return new ProgramBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case DASHBOARD:
                return new DashboardBOImpl();
            default:
                return null;
        }
    }

}
