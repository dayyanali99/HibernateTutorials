package org.learnhibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Answer;
import org.learnhibernate.entities.Question;

public class OneToOneMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Question question = new Question();
        question.setQuestionId(1212);
        question.setQuestion("What is Java ?");

        Answer answer = new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is a programming language");
        answer.setQuestion(question);
        question.setAnswer(answer);

        Question question2 = new Question();
        question2.setQuestionId(1213);
        question2.setQuestion("What is GCC ?");

        Answer answer2 = new Answer();
        answer2.setAnswerId(345);
        answer2.setAnswer("GCC is a C compiler");
        answer2.setQuestion(question2);
        question2.setAnswer(answer2);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(answer);
        session.save(answer2);
        session.save(question);
        session.save(question2);
        tx.commit();

        // fetching

        Question newQuestion = session.get(Question.class, 1212);
        System.out.println(newQuestion.getQuestion());
        System.out.println(newQuestion.getAnswer().getAnswer());

        session.close();
        sessionFactory.close();
    }
}
