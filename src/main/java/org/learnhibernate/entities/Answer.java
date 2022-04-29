package org.learnhibernate.entities;

import org.learnhibernate.entities.Question;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer
{
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private int answerId;
//    @OneToOne(mappedBy = "answer") // removes the extra foreignKey column in answer table, now bidirectional mapping is only handled by Question table's answer_id field
//    private Question question;
    @ManyToOne
    private Question question;
    private String answer;

    public Answer()
    {
    }

    public Answer(int answerId, String answer)
    {
        this.answerId = answerId;
        this.answer = answer;
    }

    public int getAnswerId()
    {
        return answerId;
    }

    public void setAnswerId(int answerId)
    {
        this.answerId = answerId;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public Question getQuestion()
    {
        return question;
    }

    public void setQuestion(Question question)
    {
        this.question = question;
    }
}
