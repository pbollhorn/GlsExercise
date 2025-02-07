package app;

import app.config.HibernateConfig;
import app.dao.ParcelDao;
import app.entities.Parcel;
import app.enums.Status;
import jakarta.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        ParcelDao parcelDao = ParcelDao.getInstance(emf);

        Parcel parcel = Parcel.builder()
                .trackingNumber("1234")
                .build();
        Parcel parcel1 = Parcel.builder()
                .trackingNumber("5678")
                .receiverName("Rolf")
                .senderName("Peter")
                .build();

        parcelDao.createParcel(parcel);
        parcelDao.createParcel(parcel1);

//        System.out.println(parcelDao.readByTrackingNumber("1234"));

//        parcelDao.readAllParcels().forEach(System.out::println);

        parcelDao.updateParcelStatus("1234", Status.IN_TRANSIT);
        System.out.println(parcelDao.readByTrackingNumber("1234"));

        parcelDao.deleteParcel("findes ikke");

    }
}