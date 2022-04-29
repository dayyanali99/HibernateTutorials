package org.learnhibernate.entities;

import org.learnhibernate.entities.Band;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Album
{
    @Id
    private int id;
    private String name;
    private int releaseYear;
    @ManyToOne()
    private Band band;

    public Album()
    {
    }

    public Album(int id, String name, int releaseYear)
    {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
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

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    public Band getBand()
    {
        return band;
    }

    public void setBand(Band band)
    {
        this.band = band;
    }

    @Override
    public String toString()
    {
        return "Album{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
