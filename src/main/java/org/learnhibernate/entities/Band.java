package org.learnhibernate.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Band
{
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "band")
    private List<Album> albums = new ArrayList<>();

    public Band()
    {
    }

    public Band(int id, String name)
    {
        this.id = id;
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

    public List<Album> getAlbums()
    {
        return albums;
    }

    public void setAlbums(List<Album> albums)
    {
        this.albums = albums;
    }

    @Override
    public String toString()
    {
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albums=" + albums +
                '}';
    }
}
