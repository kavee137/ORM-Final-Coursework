package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException, IOException;

    public boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException, IOException;

    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException, IOException;

    boolean deleteStudent(int id) throws SQLException, ClassNotFoundException, IOException;

    Student studentSearch(int id) throws SQLException, ClassNotFoundException;

}
