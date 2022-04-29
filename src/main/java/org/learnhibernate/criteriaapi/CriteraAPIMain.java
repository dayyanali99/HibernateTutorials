package org.learnhibernate.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.Band;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteraAPIMain
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Deprecated
//        Criteria criteria = session.createCriteria(TestRecord.class);
//        criteria.add(Restrictions.eq("name","Java Course 5"));
//        criteria.add(Restrictions.gt("id",45));
//        criteria.add(Restrictions.ilike("name","java%"));
//        List<TestRecord> records = criteria.list();
//
//        for (TestRecord tr : records)
//        {
//            System.out.println(tr);
//        }

        // New Way
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Band> cQuery = cb.createQuery(Band.class);
        Root<Band> root = cQuery.from(Band.class);
//        cQuery.select(root);

        // Adding restrictions
        cQuery.select(root).where(cb.like(root.<String>get("name"),"%iron%"));

        Query query = session.createQuery(cQuery);
        List<Band> results = query.getResultList();

        for (Band b : results)
        {
            System.out.println(b);
        }

        session.close();
        sessionFactory.close();
    }
}
