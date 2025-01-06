package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;

import java.io.IOException;
import java.util.List;

public interface DashboardDAO extends SuperDAO {

    List<Object[]> getPieChart2Details() throws IOException;
}
