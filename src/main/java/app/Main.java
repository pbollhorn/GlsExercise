package app;

import app.config.HibernateConfig;
import app.dao.ParcelDao;
import app.entities.Parcel;
import jakarta.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        ParcelDao parcelDao = ParcelDao.getInstance(emf);

        Parcel parcel = Parcel.builder()
                .trackingNumber("1234")
                        .build();

        parcelDao.createParcel(parcel);

        System.out.println(parcelDao.readByTrackingNumber("1234"));
    }
}