package org.learnhibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Student;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class HQLMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Creating more Students
//        Student st1 = new Student(192,"Saadi hmm", "Kazimabad");
//        Student st2 = new Student(195,"Fou Computer", "Landhi");
//        Student st3 = new Student(198,"Aun paichkass", "Kemari");
//
//        Certificate c1 = new Certificate("Hibernate","5 months");
//        Certificate c2 = new Certificate("Spring Boot","3 months");
//        Certificate c3 = new Certificate("Python","7 months");
//
//        st1.setCerti(c1);
//        st2.setCerti(c2);
//        st3.setCerti(c3);
//
//        Transaction tx = session.beginTransaction();
//        session.save(st1);
//        session.save(st2);
//        session.save(st3);
//        tx.commit();

        // HQL Syntax:
//        String queryStr = "from student where city='Landhi'"; // where Student is the name of the Class(Entity)
        // Or you can use parameterized query as follows:
        String paraQueryStr = "from student as s where s.city=:x and s.certi.course=:n";
        Query queryObj = session.createQuery(paraQueryStr);
        queryObj.setParameter("x","Landhi");
        queryObj.setParameter("n","Spring Boot");

        // if query returns unique(single) object use:
//        queryObj.uniqueResult();
        // if query returns multiple objects use:
//        List<Student> stuList = queryObj.list();
        List<Student> stuList = queryObj.getResultList();

        for (Student stu:stuList)
        {
            System.out.println(stu);
        }

        System.out.println("==============================================");

//        Transaction tx = session.beginTransaction();
//        // Delete Query:
//        String delQuery = "delete from student where city=:c";
//        Query delQueryObj = session.createQuery(delQuery);
//        delQueryObj.setParameter("c","Kazimabad");
//        int deletedEntities = delQueryObj.executeUpdate();
//        System.out.println("deleted: "+deletedEntities);
//
//        // Update Query:
//        String updateQuery = "update student set name=:n where city=:c";
//        Query updateQueryObj = session.createQuery(updateQuery);
//        updateQueryObj.setParameter("n","Zayn Chachhundar");
//        updateQueryObj.setParameter("c","Kemari");
//        int updatedEntitiy = updateQueryObj.executeUpdate();
//        System.out.println("updatedEntitiy "+updatedEntitiy);
//
//        tx.commit();

        // Join Query
        String joinQuery = "select q.question, q.questionId, a.answer " +
                "from Question as q left join q.answers as a";
        Query joinQueryObj = session.createQuery(joinQuery);

        List<Object[]> resultList = joinQueryObj.getResultList();

        for (Object[] arr: resultList)
        {
            System.out.println(Arrays.toString(arr));
        }

        session.close();
        sessionFactory.close();
    }
}
