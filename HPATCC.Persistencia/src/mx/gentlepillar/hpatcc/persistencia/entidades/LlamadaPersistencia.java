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
import mx.gentlepillar.hpatcc.nucleo.entidades.Factura;
import mx.gentlepillar.hpatcc.nucleo.entidades.Llamada;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jesus
 */
public class LlamadaPersistencia {
   /**
    * Obtiene todas las llamadas que esten registradas en la base de datos
    * @return llamadas
    */
    public List<Llamada> getAll(){
        List<Llamada> llamadas = new ArrayList<Llamada>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);
            llamadas = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener todas las Llamadas. Descripción: " + ex.getMessage());
        }
        return llamadas;
    }
    /**
     * Guarda un objeto tipo Llamada dentro de la base de datos
     * @param llamada 
     */
    public void save(Llamada llamada){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(llamada);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo Llamada");
        }
    }
    /**
     * Actualiza un objeto tipo llamada dentro de la base de datos
     * @param llamada 
     */
    public void update(Llamada llamada){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(llamada);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar actualizar el objeto de tipo Llamada");
        }
    }
    /**
     * Borra un objeto tipo Llamada dentro de la base de datos
     * @param llamada 
     */
    public void delete(Llamada llamada){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(llamada);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar borrar el objeto de tipo Llamada");
        }
    }
    /**
     * Obtene un objeto tipo llamada por ID que este registrado dentro de la base de datos
     * @param id
     * @return llamada
     */
    public Llamada getById(int id){
        Llamada llamada = new Llamada();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);
            llamada = (Llamada) session.createCriteria(Llamada.class).add(Restrictions.eq("id", id)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return llamada;
    }
          
}
