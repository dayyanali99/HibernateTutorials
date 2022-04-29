package org.learnhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Student;

public class FetchMain
{
    public static void main(String[] args)
    {
        System.out.println("Project started...");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        // Fetching data from db
        /**
         * Two methods are used to fetch data from db
         * session.get(Class, primaryKey), session.load(Class, primaryKey)
         * 1) get executes SELECT query once and puts the object in cache, for if
         * in future this object is fetched again, hibernate won't execute SELECT
         * query again instead it will get the object from cache
         *
         * 2) load doesn't execute the SELECT query but puts a proxy object
         * no matter how many of the same objects you try to load
         * in the desired Objects, it will call SELECT query once any method
         * other than getId() is called on the entity object
         */
        Student myStudent = session.get(Student.class, 8452);
        System.out.println(myStudent);

        session.close();
        sessionFactory.close();
    }
}
