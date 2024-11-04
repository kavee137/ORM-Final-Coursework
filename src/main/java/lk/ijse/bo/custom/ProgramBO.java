package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dto.ProgramDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProgramBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException;

    public boolean saveProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<ProgramDTO> getAllPrograms() throws SQLException, ClassNotFoundException;

    public boolean deleteProgram(String id) throws SQLException, ClassNotFoundException ;

    public boolean updateProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException ;

}
