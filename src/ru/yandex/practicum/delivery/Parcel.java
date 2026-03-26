package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    protected void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    };

    protected void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    };

    protected abstract double calculateDeliveryCost();

    protected abstract int getRate();
}
