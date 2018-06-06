package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import beans.Food;

@SuppressWarnings("ALL")
@Component
public class FoodDaoService
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean saveFood(Food food)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(food);
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

    public boolean updateFood(Food food)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(food);
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

    public boolean deleteFood(Food food)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(food);
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

    public Food getFoodByID(int id)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Food where foodId = ?");
            query.setInteger(0, id);
            Food food = (Food) query.uniqueResult();
            tx.commit();
            session.close();
            return food;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Food> getFoodByCityID(int foodId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Food where cityId = ?");
            query.setInteger(0, foodId);
            List foodList = query.list();
            tx.commit();
            session.close();
            return foodList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Food> getFoodListByName(String foodName)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Food where fName like ?");
            query.setString(0, "%" + foodName + "%");
            List foodList = query.list();
            tx.commit();
            session.close();
            return foodList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean increaseViewCount(int foodID)
    {
        try
        {
            Food food = getFoodByID(foodID);
            food.setViewCount(food.getViewCount() + 1);
            updateFood(food);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public List<Food> getFoodListOrderedByViewCount()
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Food order by viewCount");
            List foodList = query.list();
            tx.commit();
            session.close();
            return foodList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Food> getFoodListByCityOrderedByViewCount(int cityId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Food where cityId = ? order by viewCount");
            query.setInteger(0, cityId);
            List foodList = query.list();
            tx.commit();
            session.close();
            return foodList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
