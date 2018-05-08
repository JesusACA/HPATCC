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
import mx.gentlepillar.hpatcc.nucleo.entidades.Administrador;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jesus
 */

/** 
 * Regresa todos los administradores que esten registrados en la base de datos.
 */
public class AdministradorPersistencia {
    public List<Administrador> getAll(){
        List<Administrador> administradores = new ArrayList<Administrador>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Administrador> criteria = builder.createQuery(Administrador.class);
            criteria.from(Administrador.class);
            administradores = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener todos los Adminsitradores. Descripción: " + ex.getMessage());
        }
        return administradores;
    }
    
    /** 
     * @param administrador
     * Guarda en la base de datos un dato de tipo Administrador
     */
    
    public void save(Administrador administrador){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(administrador);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo Administrador");
        }
    }
    /** 
     * 
     * @param administrador 
     * Actualiza un dato dentro de la base de datos de tipo Administrador
     */
    public void update(Administrador administrador){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(administrador);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar actualizar el objeto de tipo Administrador");
        }
    }
    /** 
     * 
     * @param administrador
     * Borra un dato dentro de la base de datos de tipo Administrador
     */
    public void delete(Administrador administrador){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(administrador);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar borrar el objeto de tipo Administrador");
        }
    }
    /**
     * 
     * @param id
     * Busca dentro de la base de datos por ID a un objeto tipo Administrador.
     * @return administrador
     */
    public Administrador getById(int id){
        Administrador administrador = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Administrador> criteria = builder.createQuery(Administrador.class);
            criteria.from(Administrador.class);
            administrador = (Administrador) session.createCriteria(Administrador.class).add(Restrictions.eq("id", id)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return administrador;
    }
    /**
     * 
     * @param noControl
     * Busca dentro de la base de datos por Numero de Control a un tipo objeto tipo Administrador.
     * @return administrador
     */
    public Administrador getByNumControl(String noControl){
        Administrador administrador = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Administrador> criteria = builder.createQuery(Administrador.class);
            criteria.from(Administrador.class);
            administrador = (Administrador) session.createCriteria(Administrador.class).add(Restrictions.eq("noControl", noControl)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return administrador;
    }
    
    
}
