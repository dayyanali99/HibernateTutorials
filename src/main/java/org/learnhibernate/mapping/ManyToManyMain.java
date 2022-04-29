package org.learnhibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Employee;
import org.learnhibernate.entities.Project;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Employee e1 = new Employee(34, "Jan");
        Employee e2 = new Employee(35,"Nin");

        Project p1 = new Project(121, "Library Management System");
        Project p2 = new Project(123,"ChatBot");

        List<Employee> empList = new ArrayList<>();
        List<Project> projectList = new ArrayList<>();

        empList.add(e1);
        empList.add(e2);
        projectList.add(p1);
        projectList.add(p2);

        e1.setProjects(projectList);
        e2.setProjects(projectList);
        p1.setEmployees(empList);
        p2.setEmployees(empList);

        Transaction tx = session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        tx.commit();

        session.close();
        sessionFactory.close();
    }
}
