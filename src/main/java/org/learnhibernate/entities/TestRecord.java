package org.learnhibernate.entities;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

@Entity(name = "test_record")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TestRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public TestRecord()
    {
    }

    public TestRecord(String name)
    {
        this.name = name;
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

    @Override
    public String toString()
    {
        return "TestRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

