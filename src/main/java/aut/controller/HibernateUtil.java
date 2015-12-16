package aut.controller; /**
 * TODO: Description of aut.controller.HibernateUtil.
 *
 * @author ragone.
 * @version 16/12/15
 */
import aut.model.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void saveUpdateObject(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(obj);

        session.getTransaction().commit();
        session.close();
    }

    public static List<Object> getObject(String table) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Object> result = session.createQuery("from " + table).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static void deleteObject(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(obj);

        session.getTransaction().commit();
        session.close();
    }

}