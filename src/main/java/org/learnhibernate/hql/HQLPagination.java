package org.learnhibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.TestRecord;

import javax.persistence.Query;
import java.util.List;

public class HQLPagination
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query queryObj = session.createQuery("from test_record");

        // Implementing pagination using hibernate
        queryObj.setFirstResult(10);
        queryObj.setMaxResults(5);

        List<TestRecord> resultList = queryObj.getResultList();

        for (TestRecord tr : resultList)
        {
            System.out.println(tr.getId()+": "+tr.getName());
        }


        session.close();
        sessionFactory.close();
    }
}
