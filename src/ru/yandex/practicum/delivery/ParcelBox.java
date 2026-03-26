package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> list = new ArrayList<>();
    private int maxWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (parcel.weight <= getAvailableWeight()) {
            list.add(parcel);
            System.out.println("Посылка успешно добавлена в коробку");
        } else {
            System.out.println("Превышен максимально допустимый вес посылок в коробке");
        }
    }

    public void getAllParcels() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
            return;
        }

        for (T parcel : list) {
            System.out.println(parcel.description);
        }
    }

    public int getCountParcelsInBox() {
        return list.size();
    }

    private int getAvailableWeight() {
        if (list.isEmpty()) {
            return maxWeight;
        }

        int availableWeight = maxWeight;
        for (T parcel : list) {
            availableWeight -= parcel.weight;
        }

        return availableWeight;
    }
}
