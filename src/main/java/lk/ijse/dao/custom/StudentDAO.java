package lk.ijse.dao.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    List<Object[]> studentSearchForPayment(int id) throws IOException;


    String getStudentCount();

}
