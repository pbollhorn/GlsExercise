package app.populators;

import app.dao.ParcelDao;
import app.entities.Parcel;
import app.enums.Status;


import java.time.LocalDate;

public class ParcelPopulator {
    public static Parcel[] populate(ParcelDao parcelDao){
        Parcel p1 = Parcel.builder()
                .trackingNumber("5678")
                .receiverName("Rolf")
                .senderName("Peter")
                .status(Status.IN_TRANSIT)
                .build();

        p1 = parcelDao.createParcel(p1);

        Parcel p2 = Parcel.builder()
                .trackingNumber("1234")
                .receiverName("Peter")
                .senderName("julemanden")
                .status(Status.IN_TRANSIT)
                .build();

        p2 = parcelDao.createParcel(p2);
        return new Parcel[]{p1, p2};
    }
}