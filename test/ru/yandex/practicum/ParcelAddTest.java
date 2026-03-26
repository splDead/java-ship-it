package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class ParcelAddTest {
    @Test
    public void shouldBeAddStandardParcelWeight50ToStandardParcelBoxMaxWeight100() {
        ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(100);
        StandardParcel standardParcel = new StandardParcel("Standard parcel", 50, "Delivery address", 13);
        standardParcelBox.addParcel(standardParcel);
        Assertions.assertEquals(1, standardParcelBox.getCountParcelsInBox());
    }

    @Test
    public void shouldBeAddStandardParcelWeight100ToStandardParcelBoxMaxWeight100() {
        ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(100);
        StandardParcel standardParcel = new StandardParcel("Standard parcel", 100, "Delivery address", 13);
        standardParcelBox.addParcel(standardParcel);
        Assertions.assertEquals(1, standardParcelBox.getCountParcelsInBox());
    }

    @Test
    public void shouldNotBeAddStandardParcelWeight101ToStandardParcelBoxMaxWeight100() {
        ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(100);
        StandardParcel standardParcel = new StandardParcel("Standard parcel", 101, "Delivery address", 13);
        standardParcelBox.addParcel(standardParcel);
        Assertions.assertEquals(0, standardParcelBox.getCountParcelsInBox());
    }
}
