package app.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

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

    public Parcel readByTrackingNumber(String trackingNumber) {
        try (EntityManager em = emf.createEntityManager()) {
            String jpql = "SELECT p FROM Parcel p WHERE p.trackingNumber=:trackingNumber";
            TypedQuery<Parcel> query = em.createQuery(jpql, Parcel.class);
            query.setParameter("trackingNumber", trackingNumber);
            return query.getSingleResult();
        }
    }

        public List<Parcel> readAllParcels() {
            try (EntityManager em = emf.createEntityManager()) {
                String jpql = "SELECT p FROM Parcel p";
                TypedQuery<Parcel> query = em.createQuery(jpql, Parcel.class);
                return query.getResultList();
            }
        }
}