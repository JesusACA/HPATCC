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
import mx.gentlepillar.hpatcc.nucleo.entidades.Cliente;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jesus
 */
public class ClientePersistencia {

    /**
     * 
     * @param numero
     * Busca dentro de la base de datos por Numero de telefono a un objeto tipo Cliente
     * @return cliente 
     */
    public Cliente getByNumber(String numero) {
        Cliente cliente = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            cliente = (Cliente) session.createCriteria(Cliente.class).add(Restrictions.eq("numero", numero)).list().get(0);
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrión un error al intentar obtener el nombre. Descripción" + e.getMessage());
        }
        return cliente;
    }
        /**
         * Regresa todos los clientes que esten registrados en la base de datos.
         * @return clientes
         */
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            clientes = session.createQuery(criteria).getResultList();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener todos los Clientes. Descripción: " + ex.getMessage());
        }
        return clientes;
    }
/**
 * Guarda un objeto tipo Cliente dentro de la base de datos.
 * @param cliente 
 */
    public void save(Cliente cliente) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar guardad el objeto de tipo Cliente");
        }
    }
/**
 * Actualiza un objeto tipo Cliente dentro de la base de datos.
 * @param cliente 
 */
    public void update(Cliente cliente) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar actualizar el objeto de tipo Cliente");
        }
    }
/**
 * Borra un objeto tipo Cliente dentro de la base de datos.
 * @param cliente 
 */
    public void delete(Cliente cliente) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar eliminar el objeto de tipo Cliente");
        }
    }
/**
 * Busca dentro de la base de datos por Id un objeto tipo Cliente.
 * @param id
 * @return cliente
 */
    public Cliente getById(int id) {
        Cliente cliente = new Cliente();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            cliente = (Cliente) session.createCriteria(Cliente.class).add(Restrictions.eq("id", id)).list().get(0);
            session.close();
        } catch (Exception e) {
        }
        return cliente;
    }

}
