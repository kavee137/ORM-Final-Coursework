package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public ArrayList<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException {
        ArrayList<UserDTO> allUsers = new ArrayList<>();

        ArrayList<User> all = userDAO.getAll();
        for (User user : all) {
            allUsers.add(new UserDTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole()));
        }
        return allUsers;
    }

    @Override
    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(dto.getUserId(), dto.getUsername(), dto.getPassword(), dto.getRole()));
    }

    @Override
    public int generateNewID() throws SQLException, ClassNotFoundException {
        return userDAO.generateNewID();
    }

    @Override
    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getUserId(), dto.getUsername(), dto.getPassword(), dto.getRole()));
    }

    @Override
    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
        return userDAO.delete(id);
    }


}