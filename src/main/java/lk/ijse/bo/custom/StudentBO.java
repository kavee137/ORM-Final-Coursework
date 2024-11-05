package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException;

    public boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;

}
