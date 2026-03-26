package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {
    @Test
    public void shouldReturnCostStandardParcelWeight100() {
        StandardParcel parcel = new StandardParcel("Standard parcel", 100, "Delivery address", 13);
        Assertions.assertEquals(200, parcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturnCostFragileParcelWeight100() {
        FragileParcel parcel = new FragileParcel("Fragile parcel", 100, "Delivery address", 13);
        Assertions.assertEquals(300, parcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturnCostPerishableParcelWeight100() {
        PerishableParcel parcel = new PerishableParcel("Perishable parcel", 100, "Delivery address", 13, 26);
        Assertions.assertEquals(400, parcel.calculateDeliveryCost());
    }
}
