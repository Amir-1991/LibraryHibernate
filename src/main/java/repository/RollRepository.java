package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class RollRepository {
    public static List loadRoll() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select roll.rollTitle from RollEntity roll where roll.rollTitle not like :rollAdmin");
        query.setParameter("rollAdmin", "admin");
        List<String> rollList = query.getResultList();
        transaction.commit();
        session.close();
        return rollList;
    }
}
