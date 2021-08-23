package repository;

import entity.TagEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class TagRepository {
    public static void save(TagEntity newTag) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(newTag);
            transaction.commit();
        } finally {
            sessionFactory.close();
        }
    }

    public static List<TagEntity> seeAll() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select tag from TagEntity tag");
        List<TagEntity> resList = query.getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return resList;
    }
}
