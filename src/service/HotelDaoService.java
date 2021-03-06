package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import beans.Hotel;

@SuppressWarnings("ALL")
@Component
public class HotelDaoService
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean saveHotel(Hotel hotel)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(hotel);
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

    public boolean updateHotel(Hotel hotel)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(hotel);
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

    public boolean deleteHotel(Hotel hotel)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(hotel);
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

    public Hotel getHotelByID(int id)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Hotel where hotelId = ?");
            query.setInteger(0, id);
            Hotel hotel = (Hotel) query.uniqueResult();
            tx.commit();
            session.close();
            return hotel;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Hotel> getHotelByCityID(int cityId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Hotel where cityId = ?");
            query.setInteger(0, cityId);
            List hotelList = query.list();
            tx.commit();
            session.close();
            return hotelList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Hotel> getHotelListByName(String hotelName)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Hotel where hName like ?");
            query.setString(0, "%" + hotelName + "%");
            List hotelList = query.list();
            tx.commit();
            session.close();
            return hotelList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean increaseViewCount(int hotelID)
    {
        try
        {
            Hotel hotel = getHotelByID(hotelID);
            hotel.setViewCount(hotel.getViewCount() + 1);
            updateHotel(hotel);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public List<Hotel> getHotelListOrderedByViewCount()
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Hotel order by viewCount desc");
            List hotelList = query.list();
            tx.commit();
            session.close();
            return hotelList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Hotel> getHotelListByCityOrderedByViewCount(int cityId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Hotel where cityId = ? order by viewCount desc");
            query.setInteger(0, cityId);
            List hotelList = query.list();
            tx.commit();
            session.close();
            return hotelList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
