package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import beans.User;

@SuppressWarnings("ALL")
@Component
public class UserDaoService
{
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public boolean isUserExist(String email)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User where email = ?");
        query.setString(0, email);
        User user = (User) query.uniqueResult();
        tx.commit();
        session.close();
        return user != null;
    }

    public User validateUser(String email, String password)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User where email = ? and uPass = ? ");
        query.setString(0, email);
        query.setString(1, password);
        User user = (User) query.uniqueResult();
        tx.commit();
        session.close();
        return user;
    }

    public boolean saveUser(User user)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(User user)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public void test()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User");
        List list = query.list();
        tx.commit();
        System.out.println(list);
        session.close();
    }
}
