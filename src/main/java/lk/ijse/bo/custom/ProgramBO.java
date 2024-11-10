package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProgramBO extends SuperBO {

    String generateNewID() throws SQLException, ClassNotFoundException;

    public boolean saveProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<ProgramDTO> getAllPrograms() throws SQLException, ClassNotFoundException;

    public boolean deleteProgram(String id) throws SQLException, ClassNotFoundException ;

    public boolean updateProgram(ProgramDTO dto) throws SQLException, ClassNotFoundException ;

    // this method for registration UI
    public List<String> getProgramNames() throws SQLException, ClassNotFoundException;

    // this method for registration UI
    Program searchByName(String name) throws SQLException, ClassNotFoundException;

}
