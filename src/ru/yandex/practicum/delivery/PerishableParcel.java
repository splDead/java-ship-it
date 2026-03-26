package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private static final int RATE = 4;

    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    protected void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public double calculateDeliveryCost() {
        return weight * getRate();
    }

    @Override
    protected int getRate() {
        return RATE;
    }
}
