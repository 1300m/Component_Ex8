/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jiapat
 */
public class CustomerTable {
    public static void insertCustomer(Customer customer) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateCustomer(Customer customer) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        Customer fromDb = em.find(Customer.class, customer.getId());
        fromDb.setFirstname(customer.getFirstname());
        fromDb.setLastname(customer.getLastname());
        fromDb.setEmail(customer.getEmail());
        fromDb.setAddressId(customer.getAddressId());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void removeCustomer(Customer customer) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        Customer fromDb = em.find(Customer.class, customer.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }         
    }
}
