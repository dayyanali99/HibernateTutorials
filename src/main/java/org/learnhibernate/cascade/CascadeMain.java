package org.learnhibernate.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Answer;
import org.learnhibernate.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class CascadeMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Question q1 = new Question();
        q1.setQuestionId(567);
        q1.setQuestion("What is Cascading ?");

        Answer a1 = new Answer(2623, "In hibernate is important concept");
        a1.setQuestion(q1);
        Answer a2 = new Answer(2624, "2nd Answer...");
        a2.setQuestion(q1);
        Answer a3 = new Answer(2625, "3rd Answer...");
        a3.setQuestion(q1);
        List<Answer> ansList = new ArrayList<>();
        ansList.add(a1);
        ansList.add(a2);
        ansList.add(a3);
        q1.setAnswers(ansList);

        session.beginTransaction();
        session.save(q1);
        session.getTransaction().commit();

        // Cascaded Option enabled in Question class on answers entity
        // now any operation on Question will also be performed on all
        // its answers, For eg: now we can save q1 without explicitly
        // saving all the answers first

        session.close();
        sessionFactory.close();
    }
}
