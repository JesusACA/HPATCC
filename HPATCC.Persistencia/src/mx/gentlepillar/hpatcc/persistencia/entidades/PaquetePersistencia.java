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
<<<<<<< HEAD

    public List<Paquete> getAll() {
=======
/**
 * Obtiene todos los objetos tipo Paquete que esten registrados dentro de la base de datos.
 * @return paquetes
 */
    public List<Paquete> obtenerTodos() {
>>>>>>> bb341d61fa2e074d070a05427795d767890be9b2
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
/**
 * Guarda un objeto tipo paquete dentro de la base de datos
 * @param paquete 
 */
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
/**
 * Actualiza un objeto tipo paquete dentro de la base de datos.
 * @param paquete 
 */
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
/**
 *Borra un objeto tipo paquete dentro de la base de datos
 * @param paquete 
 */
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
/**
 * Obtiene un registro por ID de un objeto tipo Paquete registrado dentro de la base de datos.
 * @param id
 * @return 
 */
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
