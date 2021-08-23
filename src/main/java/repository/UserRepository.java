package repository;

import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class UserRepository {
    public static void save(UserEntity newUser) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(newUser);
            transaction.commit();
        } finally {
            sessionFactory.close();
        }
    }

    public static List load(List<String> logInfo) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select use from UserEntity use where use.userName like :userName");
        query.setParameter("userName", logInfo.get(0));
        List<UserEntity> resList = query.getResultList();
        transaction.commit();
        session.close();
        return resList;
    }

    public static void updateUserRoll(List<String> editRollAdmin) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update UserEntity use set use.rollTitle=:rollTitle where use.userName=:userName");
        query.setParameter("userName", editRollAdmin.get(0));
        query.setParameter("rollTitle", editRollAdmin.get(1));
        transaction.commit();
        session.close();
    }

    public static void deleteUser() {

    }

    public static void updateUserSession() {
    }
}
