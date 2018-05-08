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
import mx.gentlepillar.hpatcc.nucleo.entidades.Cliente;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jesus
 */
public class FacturaPersistencia {
/**
 * Obtiene todos los registrs de Factura dentro de la base de datos
 * @return 
 */
    public List<Factura> obtenerTodos() {
        List<Factura> facturas = new ArrayList<Factura>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Factura> criteria = builder.createQuery(Factura.class);
            criteria.from(Factura.class);
            facturas = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener todas las Facturas. Descripción: " + ex.getMessage());
        }
        return facturas;
    }
/**
 * Guarda un objeto tipo factura dentro de la base de datos.
 * @param factura 
 */
    public void save(Factura factura) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(factura);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo factura");
        }
    }
/**
 * Actualiza un objeto tipo Factura dentro de la base de datos.
 * @param factura 
 */
    public void update(Factura factura) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(factura);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar actualizar el objeto de tipo factura");
        }
    }
/**
 * Borra un objeto tipo factura dentro de la base de datos.
 * @param factura 
 */
    public void delete(Factura factura) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(factura);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar eliminar el objeto de tipo factura");
        }
    }
/**
 * Obtiene por id todos los registrs de tipo Factura dentro de la base de datos
 * @param id
 * @return 
 */
    public Factura getById(int id) {
        Factura factura = new Factura();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Factura> criteria = builder.createQuery(Factura.class);
            criteria.from(Factura.class);
            factura = (Factura) session.createCriteria(Factura.class).add(Restrictions.eq("id", id)).list().get(0);
            session.close();
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar la factura deseada");
        }
        return factura;
    }

    /**
     * Recupera las facturas indicando el año y el cliente que esten dentro de la base de datos.
     * @param year
     * @param cliente
     * @return facturas
     */
    public List<Factura> getByYear(int year, Cliente cliente) {
        List<Factura> facturas = new ArrayList<Factura>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Factura> criteria = builder.createQuery(Factura.class);
            criteria.from(Factura.class);
            facturas = session.createCriteria(Factura.class).add(Restrictions.and(Restrictions.eq("anio", year), Restrictions.eq("cliente", cliente))).list();
            session.close();
        } catch (Exception e) {
            System.out.println("No se han podido recuperar las facturas deseadas");
        }
        return facturas;
    }
/**
 * Recuera las facturas indicando el mes y el cliente que esten dentro de la base de datos.
 * @param month
 * @param cliente
 * @return factura
 */
    public Factura getByMonth(int month, Cliente cliente) {
        Factura factura = new Factura();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Factura> criteria = builder.createQuery(Factura.class);
            criteria.from(Factura.class);
            factura = (Factura) session.createCriteria(Factura.class).add(Restrictions.and(Restrictions.eq("mes", month), Restrictions.eq("cliente", cliente))).list().get(0);
            session.close();
        } catch (Exception e) {
            System.out.println("No se han podido recuperar las facturas deseadas");
        }
        return factura;
    }
}
