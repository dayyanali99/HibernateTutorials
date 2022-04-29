package org.learnhibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learnhibernate.entities.TestRecord;

public class SecondLevelCacheMain
{
    public static void main(String[] args)
    {
        /**
         * use 'ehcache' and 'hibernate cache' maven dependencies to enable
         * 2nd level(SessionFactory) caching.
         *
         * Add 2 more properties to hibernate.cfg.xml file:
         * 1) cache.use_second_level_cache = true
         * 2) cache.region.factory_class = net.sf.ehcache.hibernate.EhCacheRegionFactory
         *
         * Add 2 annotations on Entity that you want cached:
         * @cacheable
         * @cache(usage = 'select.appropriate.option.here')
         */

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session1 = sessionFactory.openSession();

        TestRecord ob1 = session1.get(TestRecord.class, 5);
        System.out.println(ob1);

        session1.close();

        Session session2 = sessionFactory.openSession();

        TestRecord ob2 = session2.get(TestRecord.class, 5);
        System.out.println(ob2);

        session2.close();

        sessionFactory.close();

    }
}
