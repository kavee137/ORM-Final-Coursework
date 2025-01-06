package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.DashboardBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.DashboardDAO;
import lk.ijse.dao.custom.StudentDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

public class DashboardBOImpl implements DashboardBO {


    DashboardDAO dashboardDAO = (DashboardDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DASHBOARD);

    @Override
    public List<Object[]> getPieChart2Details() throws IOException {
        return dashboardDAO.getPieChart2Details();
    }
}
