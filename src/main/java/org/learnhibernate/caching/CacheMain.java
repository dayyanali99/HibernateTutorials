package org.learnhibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.TestRecord;

public class CacheMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // First Level Cache (Session cache) is by default enabled
        TestRecord obj1 = session.get(TestRecord.class, 5);
        System.out.println(obj1);
        System.out.println("Working ...........");
        TestRecord obj2 = session.get(TestRecord.class, 5);
        System.out.println(obj2);

        session.close();
        sessionFactory.close();
    }
}
