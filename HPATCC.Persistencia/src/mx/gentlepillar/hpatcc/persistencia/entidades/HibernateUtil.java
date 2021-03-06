/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gentlepillar.hpatcc.persistencia.entidades;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author osmar
 */
public class HibernateUtil {
    private static StandardServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    /**
     * Inicia la sesión de Hibernate para poder tener conexión a la base de datos.
     * @return 
     */
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
               serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metaSources = new MetadataSources(serviceRegistry);
                Metadata metadata = metaSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception ex) {
                System.out.println("Ocurrió un error al intentar generar la sesión de Hibernate. Descripción: " + ex.getMessage());
                if (serviceRegistry != null) {
                    StandardServiceRegistryBuilder.destroy(serviceRegistry);
                }
            }
        }
        return sessionFactory;
    }

    public static void destroy() {
        if (serviceRegistry != null) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
}
}
