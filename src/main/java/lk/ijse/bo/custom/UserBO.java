package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException;

    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException;

    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException ;

    boolean deleteUser(int id) throws SQLException, ClassNotFoundException;
}
