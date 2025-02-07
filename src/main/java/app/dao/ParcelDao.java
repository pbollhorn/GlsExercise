package app.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import app.entities.Parcel;


public class ParcelDao {

    private static ParcelDao instance;
    private static EntityManagerFactory emf;

    private ParcelDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static ParcelDao getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new ParcelDao(emf);
        }
        return instance;
    }

    public Parcel createParcel(Parcel p) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }
    }




}
