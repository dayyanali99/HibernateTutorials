package org.learnhibernate.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SQLMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        String sqlQuery = "select * from test_record";
        NativeQuery nq = session.createSQLQuery(sqlQuery);
        List<Object[]> resultList = nq.getResultList();

        for (Object[] tr : resultList)
        {
            System.out.println(Arrays.toString(tr));
        }

        Object[] tr1 = resultList.get(5);
        System.out.println(tr1[1]);

        session.close();
        sessionFactory.close();
    }
}
