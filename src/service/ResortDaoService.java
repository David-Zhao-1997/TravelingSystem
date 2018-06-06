package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import beans.Resort;

@SuppressWarnings("ALL")
@Component
public class ResortDaoService
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean saveResort(Resort resort)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(resort);
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

    public boolean updateResort(Resort resort)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(resort);
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

    public boolean deleteResort(Resort resort)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(resort);
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

    public Resort getResortByID(int id)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Resort where resortId = ?");
            query.setInteger(0, id);
            Resort resort = (Resort) query.uniqueResult();
            tx.commit();
            session.close();
            return resort;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Resort> getResortByCityID(int cityId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Resort where cityId = ?");
            query.setInteger(0, cityId);
            List resortList = query.list();
            tx.commit();
            session.close();
            return resortList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Resort> getResortListByName(String resortName)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Resort where hName like ?");
            query.setString(0, "%" + resortName + "%");
            List resortList = query.list();
            tx.commit();
            session.close();
            return resortList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean increaseViewCount(int resortID)
    {
        try
        {
            Resort resort = getResortByID(resortID);
            resort.setViewCount(resort.getViewCount() + 1);
            updateResort(resort);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public List<Resort> getResortListOrderedByViewCount()
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Resort order by viewCount desc");
            List resortList = query.list();
            tx.commit();
            session.close();
            return resortList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Resort> getResortListByCityOrderedByViewCount(int cityId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Resort where cityId = ? order by viewCount desc");
            query.setInteger(0, cityId);
            List resortList = query.list();
            tx.commit();
            session.close();
            return resortList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
