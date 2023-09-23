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
public class AddressTable {
    public static void insertAddress(Address address) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(address);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateAddress(Address address) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        Address fromDb = em.find(Address.class, address.getId());
        fromDb.setStreet(address.getStreet());
        fromDb.setCity(address.getCity());
        fromDb.setZipcode(address.getZipcode());
        fromDb.setCountry(address.getCountry());
        fromDb.setCustomerFk(address.getCustomerFk());
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
    
    public static void removeAddress(Address address) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        Address fromDb = em.find(Address.class, address.getId());
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
