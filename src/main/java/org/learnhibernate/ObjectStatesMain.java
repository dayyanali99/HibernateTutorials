package org.learnhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Certificate;
import org.learnhibernate.entities.Student;

public class ObjectStatesMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Hibernate Object States:
        // 1. Transient
        // 2. Persistent
        // 3. Detached
        // 4. Removed

        Student student = new Student();
        student.setId(1414);
        student.setName("Peter");
        student.setCity("Shalimaar");
        student.setCerti(new Certificate("Java Hibernated Course", "2 months"));
        // student obj is now in transient state

        Transaction tx = session.beginTransaction();
        session.save(student);
        // student obj is now in persistent state, because it's associated with both
        // the session object AND database
        student.setName("John Wick");
        // Changing the object's properties when it's in persistent state will also
        // be reflected in the database
        tx.commit();

        session.close();
        // If session is closed or cleared, the object goes into detached state
        // which means that it's in database but not in session anymore
        // now any more changes in the object from here on won't reflect in the database
        sessionFactory.close();
    }
}
