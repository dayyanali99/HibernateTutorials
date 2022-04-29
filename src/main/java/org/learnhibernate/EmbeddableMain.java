package org.learnhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Certificate;
import org.learnhibernate.entities.Student;

public class EmbeddableMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Student st1 = new Student();
        st1.setId(1341);
        st1.setName("Ankit Tiwari");
        st1.setCity("Lucknow");
        Certificate certi = new Certificate();
        certi.setCourse("Android");
        certi.setDuration("2 Months");
        st1.setCerti(certi);

        Student st2 = new Student();
        st2.setId(5131);
        st2.setName("Sonu nigam");
        st2.setCity("Bhareshpur");
        Certificate certi2 = new Certificate();
        certi2.setCourse("Spring Boot");
        certi2.setDuration("5 Months");
        st2.setCerti(certi2);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(st1);
        session.save(st2);

        tx.commit();

        session.close();
        sessionFactory.close();
    }
}
