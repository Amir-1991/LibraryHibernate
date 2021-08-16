package repository;

import entity.userEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class userRepository {
    public static void save() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.save(new userEntity());
            session.getTransaction().commit();
        } finally {

        }
        sessionFactory.close();
    }
}
