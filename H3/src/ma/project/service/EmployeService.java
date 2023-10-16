package ma.project.service;


import java.util.List;
import ma.project.classes.Employe;
import ma.project.dao.IDao;

//import ma.projet.entities.LigneCommandeProduit;
//import ma.projet.entities.Produit;
import ma.project.util.HibernateUtil;
import ma.project.classes.Projet;
import ma.project.classes.Tache;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author hp
 */
public class EmployeService implements IDao <Employe> {

    @Override
     public boolean create(Employe o) {
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
    public List<Employe> getAll() {
         List<Employe> employes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employes").list();
            tx.commit();
            return employes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return employes;
        } finally {
            if(session != null)
                session.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employe getById(int id) {
        
        Employe employe = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = (Employe) session.get( Employe.class,id );
            tx.commit();
            return employe;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return employe;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     public List <Tache> tacheEmploye(Employe employe){

        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            
            String hql = "SELECT t FROM Tache t WHERE t.employe = :employe";
            Query query = session.createQuery(hql);
            query.setParameter("employe", employe);

            taches = query.list();

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return taches;
    }
      public List<Projet> projetEmploye(Employe employe) {
        List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Use HQL to fetch projects associated with the given employee
            String hql = "SELECT p FROM Projet p WHERE p.manager = :employe";
            Query query = session.createQuery(hql);
            query.setParameter("employe", employe);

            projets = query.list();

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace(); // Handle the exception according to your needs
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return projets;
    }
       public List<Tache> getTachesRealise() {
          List<Tache> taches = null;
          Session session = null;
          Transaction tx = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();
                String hql = "FROM EmployeTache e where e.employeid = :";
                Query query = session.createQuery(hql);
                query.setParameter("employeid", null);
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


