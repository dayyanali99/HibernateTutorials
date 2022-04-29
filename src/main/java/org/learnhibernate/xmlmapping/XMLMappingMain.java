package org.learnhibernate.xmlmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XMLMappingMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person p1 = new Person(23, "Danny", "Delhi", "92839");
        session.save(p1);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
