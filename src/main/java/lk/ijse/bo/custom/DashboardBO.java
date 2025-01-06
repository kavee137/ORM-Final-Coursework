package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

public interface DashboardBO extends SuperBO {
    List<Object[]> getPieChart2Details() throws IOException;
}
