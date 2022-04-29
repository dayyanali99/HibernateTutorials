package org.learnhibernate.pracjoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.*;

public class JoinPracMain
{
    public static void main(String[] args)
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

//        Band ironMaiden = new Band(1,"Iron Maiden");
//        Band judasPriest = new Band(2, "Judas Priest");
//
//        Album a1 = new Album(1,"The Number of the Beast", 1982);
//        a1.setBand(ironMaiden);
//        Album a2 = new Album(2,"Painkiller", 1990);
//        a2.setBand(judasPriest);
//        Album a3 = new Album(3,"Power Slave", 1984);
//        a3.setBand(ironMaiden);
//        Album a4 = new Album(4,"Killers", 1981);
//        a4.setBand(ironMaiden);
//        Album a5 = new Album(5,"Rocka Rolla", 1974);
//        a5.setBand(judasPriest);
//
//        Collection<Album> maidenList = new ArrayList<>();
//        maidenList.add(a1);
//        maidenList.add(a3);
//        maidenList.add(a4);
//
//        Collection<Album> priestList = new ArrayList<>();
//        priestList.add(a2);
//        priestList.add(a5);
//
//        ironMaiden.setAlbums(maidenList);
//        judasPriest.setAlbums(priestList);
//
//        s.beginTransaction();
//        s.save(a1);
//        s.save(a2);
//        s.save(a3);
//        s.save(a4);
//        s.save(a5);
//        s.save(ironMaiden);
//        s.save(judasPriest);
//        s.getTransaction().commit();

        String joinQ = "select b.name, a.name ,a.releaseYear " +
                "from Band as b inner join b.albums as a where b.name='Iron Maiden'";
        Query queryObj = s.createQuery(joinQ);

        Collection<Object[]> collection = queryObj.getResultList();

        for(Object[] band : collection)
        {
            System.out.println(Arrays.toString(band));
        }

        s.close();
        sf.close();
    }
}
