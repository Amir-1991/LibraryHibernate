package repository;

import entity.userEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class userRepository {
    public static void save(userEntity newUser) {
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
        Query query = session.createQuery("select use from userEntity use where use.userName like :userName");
        query.setParameter("userName", logInfo.get(0));
        List<userEntity> resList = query.getResultList();
        transaction.commit();
        session.close();
        return resList;
    }

    public static void updateUser(List<String> editUser){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select use.rollTitle from userEntity use where use.userName like :userName");
        query.setParameter("userName", editUser.get(0));
//        String currentRoll=
        System.out.println(query.getResultList());
        Query queryUpdate = session.createQuery("update userEntity use set use.userName =:userName,use.password =:password,use.rollTitle=:rollTitle");
        queryUpdate.setParameter("userName", editUser.get(0));
        List<userEntity> resList = query.getResultList();
        transaction.commit();
        session.close();
    }

    public static void deleteUser() {

    }

    public static void updateUserSession() {
    }
}
