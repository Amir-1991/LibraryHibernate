package repository;

import entity.categoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class categoryRepository {

    public static void save(categoryEntity newCategory) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(newCategory);
            transaction.commit();
        } finally {
            sessionFactory.close();
        }
    }

    public static void editCategory(List<String> editCategory) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update categoryEntity cat set cat.title=:newTitle, cat.description=:newDesc where cat.title=:currentTitle");
        query.setParameter("currentTitle", editCategory.get(0));
        query.setParameter("newTitle", editCategory.get(1));
        query.setParameter("newDesc", editCategory.get(2));
        transaction.commit();
        session.close();
    }

    public static void deleteCategory() {
    }
}
