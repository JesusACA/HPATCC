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
import mx.gentlepillar.hpatcc.nucleo.entidades.Configuracion;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jesus
 */
public class ConfiguracionPersistencia {
    
    /**
     * Regresa todas las configuraciones que esten registradas en la base de datos.
     * @return configuraciones
     */
    public List<Configuracion> obtenerTodos(){
        List<Configuracion> configuraciones = new ArrayList<Configuracion>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Configuracion> criteria = builder.createQuery(Configuracion.class);
            criteria.from(Configuracion.class);
            configuraciones = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener todas las configuracioens. Descripción: " + ex.getMessage());
        }
        return configuraciones;
    }
    /**
     *Guarda un objeto tipo configuracion dentro de la base de datos.
     * @param configuracion 
     */
    public void save(Configuracion configuracion){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(configuracion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo configuracion");
        }
    }
    /**
     * Actualiza un objeto tipo Configuracion dentro de la base de datos
     * @param configuracion 
     */
    public void update(Configuracion configuracion){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(configuracion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar actualizar el objeto de tipo configuracion");
        }
    }
    /**
     * Elimina un objeto tipo Configuracion dentro de la base de datos
     * @param configuracion 
     */
    public void delete(Configuracion configuracion){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(configuracion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar eliminar el objeto de tipo configuracion");
        }
    }
    /**
     * 
     * @param id
     * Obtiene por ID un objeto tipo Configuracion que este registrado dentro de la base de datos
     * @return 
     */
    public Configuracion getById(int id){
        Configuracion configuracion = new Configuracion();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Configuracion> criteria = builder.createQuery(Configuracion.class);
            criteria.from(Configuracion.class);
            configuracion = (Configuracion) session.createCriteria(Configuracion.class).add(Restrictions.eq("id", id)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return configuracion;
    }
}
