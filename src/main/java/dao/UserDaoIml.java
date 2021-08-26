package dao;

import model.Auto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.Util;
import model.User;

import javax.transaction.*;
import java.util.List;


public class UserDaoIml {

    public User findById(int id) {
        return Util.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public void update(User user) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
    }

    public void delete(User user) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public Auto findAutoById(int id) {
        return Util.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>) Util.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }


}
