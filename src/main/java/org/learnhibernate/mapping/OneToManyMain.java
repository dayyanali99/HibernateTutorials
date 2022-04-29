package org.learnhibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Answer;
import org.learnhibernate.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Question question = new Question();
        question.setQuestionId(1212);
        question.setQuestion("What is Java ?");

        Answer answer1 = new Answer();
        answer1.setAnswerId(343);
        answer1.setQuestion(question);
        answer1.setAnswer("Java is a Programming Language");

        Answer answer2 = new Answer();
        answer2.setAnswerId(443);
        answer2.setQuestion(question);
        answer2.setAnswer("Application making Tool");

        Answer answer3 = new Answer();
        answer3.setAnswerId(543);
        answer3.setQuestion(question);
        answer3.setAnswer("Software development kit");

        List<Answer> list = new ArrayList<>();
        list.add(answer1);
        list.add(answer2);
        list.add(answer3);

        question.setAnswers(list);

        // Saving object in db
//        Transaction tx = session.beginTransaction();
//        session.save(answer1);
//        session.save(answer2);
//        session.save(answer3);
//        session.save(question);
//        tx.commit();

        Question q1 = session.get(Question.class, 1212);

        System.out.println(q1.getQuestion());
        for (Answer ans: q1.getAnswers())
        {
            System.out.println(ans.getAnswer());
        }



        session.close();
        sessionFactory.close();
    }
}
