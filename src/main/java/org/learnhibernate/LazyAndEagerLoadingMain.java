package org.learnhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Project;
import org.learnhibernate.entities.Question;

public class LazyAndEagerLoadingMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Question q = session.get(Question.class, 1212);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswers().size());

        Project testProject = new Project(122,"testProject");

        Transaction tx = session.beginTransaction();
        session.save(testProject);
//        session.delete(testProject);
        tx.commit();

        session.close();
        sessionFactory.close();
    }
}
