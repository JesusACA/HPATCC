/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import mx.gentlepillar.hpatcc.nucleo.entidades.Paquete;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jesus
 */
public class PaquetePersistencia {

    public List<Paquete> getAll() {
        List<Paquete> paquetes = new ArrayList<Paquete>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Paquete> criteria = builder.createQuery(Paquete.class);
            criteria.from(Paquete.class);
            paquetes = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener todos los Paquetes. Descripción: " + ex.getMessage());
        }
        return paquetes;
    }

    public void save(Paquete paquete) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(paquete);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo paquete");
        }
    }

    public void update(Paquete paquete) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(paquete);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar actualizar el objeto de tipo paquete");
        }
    }

    public void delete(Paquete paquete) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(paquete);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar eliminar el objeto de tipo paquete");
        }
    }

    public Paquete getById(int id) {
        Paquete paquete = new Paquete();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Paquete> criteria = builder.createQuery(Paquete.class);
            criteria.from(Paquete.class);
            paquete = (Paquete) session.createCriteria(Paquete.class).add(Restrictions.eq("id", id)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return paquete;
    }
    
    public Paquete getByName(String nombre){
        Paquete paquete = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Paquete> criteria = builder.createQuery(Paquete.class);
            criteria.from(Paquete.class);
            paquete = (Paquete) session.createCriteria(Paquete.class).add(Restrictions.eq("nombre", nombre)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return paquete;
    }
}
