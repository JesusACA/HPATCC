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
    
    public void delte(Administrador administrador){
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
