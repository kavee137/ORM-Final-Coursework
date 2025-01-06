package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.custom.QueryDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<Object[]> studentSearchForPayment(int studentId) throws IOException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Object[]> results = new ArrayList<>();

        try {

            // HQL query with studentId filter
            String hql = "SELECT r.regId, r.paidAmount, r.program.programId, r.student.studentId, r.student.name, r.program.fee, r.program.programName " +
                    "FROM Registration r " +
                    "JOIN r.student s " +
                    "JOIN r.program p " +
                    "WHERE r.student.studentId = :studentId";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("studentId", studentId);  // Set the studentId parameter

            // Execute the query and get the result list
            results = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Override
    public List<Object[]> getPieChart2Details() throws IOException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            String hql = "SELECT p.programId, p.programName, COUNT(DISTINCT r.student.studentId) FROM Program p JOIN p.registrations r GROUP BY p.programId, p.programName";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.list(); // Fetch the results
            transaction.commit();
            return results;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


}
