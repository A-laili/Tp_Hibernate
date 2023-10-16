package ma.project.service;

import java.util.List;
import ma.project.classes.EmployeTache;
import ma.project.dao.IDao;
import ma.project.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Asmaa
 */
public class EmployeTacheService implements IDao<EmployeTache> {

    @Override
    public boolean create(EmployeTache o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmployeTache> getAll() {
        List<EmployeTache> employeTache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTache = session.createQuery("from EmployeTache").list();
            tx.commit();
            return employeTache;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return employeTache;
        } finally {
            if(session != null)
                session.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmployeTache getById(int id) {
         EmployeTache employeTache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTache = (EmployeTache) session.get(EmployeTache.class, id);
            tx.commit();
            return employeTache;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return employeTache;
        } finally {
            if (session != null) {
                session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }
    
}