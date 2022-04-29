package org.learnhibernate.entities;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;

@Entity(name = "student")
//@Table(name = "gives table name in db")
public class Student
{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    @Embedded
    private Certificate certi;

    public Student(int id, String name, String city)
    {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public Certificate getCerti()
    {
        return certi;
    }

    public void setCerti(Certificate certi)
    {
        this.certi = certi;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", certi=" + certi +
                '}';
    }
}
