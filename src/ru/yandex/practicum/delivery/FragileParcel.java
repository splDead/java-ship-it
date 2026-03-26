package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    private static final int RATE = 3;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double calculateDeliveryCost() {
        return weight * getRate();
    }

    @Override
    protected int getRate() {
        return RATE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }
}
