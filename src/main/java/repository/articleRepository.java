package repository;

import entity.articleEntity;
import entity.userEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class articleRepository {
    public static void save(articleEntity newArticle) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(newArticle);
            transaction.commit();
        } finally {
            sessionFactory.close();
        }
    }

    public static void editArticle(List<String> editArticle) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("");
        query.setParameter("userName", editArticle.get(0));
        List<userEntity> resList = query.getResultList();
        transaction.commit();
        session.close();
            sessionFactory.close();
    }

    public static void deleteArticle(List<String> deleteArticle) {
    }
}
