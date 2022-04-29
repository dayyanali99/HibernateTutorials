package org.learnhibernate.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question
{
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private int questionId;
    private String question;
//    @OneToOne
    @Transient // making this transient to test OneToMany relationship
    private Answer answer;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Question()
    {
    }

    public Question(int questionId, String question, List<Answer> answers)
    {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Answer getAnswer()
    {
        return answer;
    }

    public void setAnswer(Answer answer)
    {
        this.answer = answer;
    }

    public List<Answer> getAnswers()
    {
        return answers;
    }

    public void setAnswers(List<Answer> answers)
    {
        this.answers = answers;
    }
}
