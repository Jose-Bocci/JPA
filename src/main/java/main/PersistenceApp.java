package main;

import entidades.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class PersistenceApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemasDistribuidosJPAPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = new Cliente("José", "Bocci", 42794565);
            em.persist(cliente);
            em.flush();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }

        em.close();
        emf.close();


    }
}
