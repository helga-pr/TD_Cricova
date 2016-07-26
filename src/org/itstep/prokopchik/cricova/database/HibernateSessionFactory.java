package org.itstep.prokopchik.cricova.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {


    private static ServiceRegistry serviceRegistry;

    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = buildSessionFactory();
        } catch (Exception ex) {
            //TODO: добавить логирование
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

    protected static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
