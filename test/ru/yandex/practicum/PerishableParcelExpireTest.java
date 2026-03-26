package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class PerishableParcelExpireTest {
    @Test
    public void shouldBeNegativeExpire() {
        PerishableParcel parcel = new PerishableParcel("Perishable parcel", 100, "Delivery address", 13, 26);
        Assertions.assertFalse(parcel.isExpired(20));
    }

    @Test
    public void shouldBeNegativeExpireByLastDay() {
        PerishableParcel parcel = new PerishableParcel("Perishable parcel", 100, "Delivery address", 5, 10);
        Assertions.assertFalse(parcel.isExpired(15));
    }

    @Test
    public void shouldBePositiveExpire() {
        PerishableParcel parcel = new PerishableParcel("Perishable parcel", 100, "Delivery address", 1, 3);
        Assertions.assertTrue(parcel.isExpired(20));
    }
}
