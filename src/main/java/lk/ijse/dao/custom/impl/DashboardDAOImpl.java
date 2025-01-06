package lk.ijse.dao.custom.impl;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.DashboardDAO;
import lk.ijse.dao.custom.QueryDAO;

import java.io.IOException;
import java.util.List;

public class DashboardDAOImpl implements DashboardDAO {

    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<Object[]> getPieChart2Details() throws IOException {
        return queryDAO.getPieChart2Details();
    }
}
