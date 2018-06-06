package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import beans.City;

@SuppressWarnings("ALL")
@Component
public class CityDaoService
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean saveCity(City city)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(city);
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

    public boolean updateCity(City city)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(city);
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

    public boolean deleteCity(City city)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(city);
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

    public City getCityByID(int id)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from City where cityId = ?");
            query.setInteger(0, id);
            City city = (City) query.uniqueResult();
            tx.commit();
            session.close();
            return city;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<City> getCityListByName(String cityName)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from City where cName like ?");
            query.setString(0, "%" + cityName + "%");
            List cityList = query.list();
            tx.commit();
            session.close();
            return cityList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<City> getCityListOrderedByViewCount()
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from City order by viewCount desc");
            List cityList = query.list();
            tx.commit();
            session.close();
            return cityList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean increaseViewCount(int cityID)
    {
        try
        {
            City city = getCityByID(cityID);
            city.setViewCount(city.getViewCount() + 1);
            updateCity(city);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}