/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.service;

/**
 *
 * @author Asmaa
 */
import java.util.List;
import ma.project.dao.IDao;
import ma.project.classes.Tache;
import ma.project.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TacheService implements IDao <Tache> {
    @Override
    public boolean create(Tache o) {
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
        }
    }

   
   

    @Override
    public List<Tache> getAll() {
        List<Tache> tache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = session.createQuery("from Tache").list();
            tx.commit();
            return tache;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return tache;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public Tache getById(int id) {
        Tache tache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = (Tache) session.get(Tache.class, id);
            tx.commit();
            return tache;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return tache;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
      public List<Tache> getTachesPrixSuperieur(double prix){
        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            String hql = "FROM Tache t WHERE t.prix > :prixLimite";
            Query query = session.createQuery(hql);
            query.setParameter("prixLimite", prix);
            taches = query.list();
            return taches;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return taches;
        } finally {
            if(session != null)
                session.close();
        }
    }

}
