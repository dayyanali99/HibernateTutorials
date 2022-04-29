package org.learnhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Address;
import org.learnhibernate.entities.Student;

import java.io.FileInputStream;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class InsertMain
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Project Started..." );

        // Configuring and getting Session Factory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // OR
//        SessionFactory factory =
//                new Configuration().configure().buildSessionFactory();

        System.out.println(sessionFactory);
        System.out.println(sessionFactory.isClosed());


        // Creating Student
//        Student student = new Student(666,"Aun","Landhi");
//
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//        session.save(student);
//        transaction.commit();

        // Creating Address
        Address address = new Address();
        address.setStreet("street1");
        address.setCity("Karachi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(2135.23);

        // Reading image
        try (FileInputStream fis =
                     new FileInputStream(InsertMain.class.getClassLoader().getResource("important_hibernate_annotations.png").getPath()))
        {
            byte[] data = new byte[fis.available()];
            fis.read(data);
            address.setImage(data);
        }


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
//        session.save(student);
        transaction.commit();
        session.close();

    }
}
