package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import beans.Note;

@SuppressWarnings("ALL")
@Component
public class NoteDaoService
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean saveNote(Note note)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(note);
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

    public boolean updateNote(Note note)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(note);
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

    public boolean deleteNote(Note note)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(note);
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

    public Note getNoteByID(int id)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Note where noteId = ?");
            query.setInteger(0, id);
            Note note = (Note) query.uniqueResult();
            tx.commit();
            session.close();
            return note;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Note> getNoteByResortID(int resortId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Note where resortId = ?");
            query.setInteger(0, resortId);
            List noteList = query.list();
            tx.commit();
            session.close();
            return noteList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Note> getNoteByCityID(int cityId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Note where cityId = ?");
            query.setInteger(0, cityId);
            List noteList = query.list();
            tx.commit();
            session.close();
            return noteList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public int getUpNumberByNoteID(int noteId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            NativeQuery query = session.createNativeQuery("select count(*) from TravelingSystem.dbo.Note where NoteID = ? and Up = 1");
            query.setParameter(1, noteId);
            int number = (int) session.createSQLQuery("").uniqueResult();
            tx.commit();
            session.close();
            return number;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public int getDownNumberByNoteID(int noteId)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            NativeQuery query = session.createNativeQuery("select count(*) from TravelingSystem.dbo.Note where NoteID = ? and Down = 1");
            query.setParameter(1, noteId);
            int number = (int) session.createSQLQuery("").uniqueResult();
            tx.commit();
            session.close();
            return number;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
