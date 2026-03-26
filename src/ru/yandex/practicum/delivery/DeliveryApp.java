package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(300);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(200);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(100);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportParcels();
                    break;
                case 5:
                    showContentBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Трекинг посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void showParcelTypeMenu() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        showParcelTypeMenu();
        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите описание посылки");
        String description = scanner.nextLine();

        System.out.println("Введите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки");
        int sendDay = Integer.parseInt(scanner.nextLine());

        Parcel parcel;

        switch (type) {
            case 1:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardParcelBox.addParcel((StandardParcel) parcel);
                break;
            case 2:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                trackableParcels.add((FragileParcel) parcel);
                fragileParcelBox.addParcel((FragileParcel) parcel);
                break;
            case 3:
                System.out.println("Введите срок годности");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableParcelBox.addParcel((PerishableParcel) parcel);
                break;
            default:
                System.out.println("Неверный тип посылки");
                return;
        }

        allParcels.add(parcel);
        System.out.println("Посылка успешно добавлена в список");
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }

        System.out.println("Общая стоимость всех посылок: " + sum);
    }

    private static void reportParcels() {
        System.out.println("Введите новый адрес");
        String newLocation = scanner.nextLine();

        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void showContentBox() {
        showParcelTypeMenu();
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                standardParcelBox.getAllParcels();
                break;
            case 2:
                fragileParcelBox.getAllParcels();
                break;
            case 3:
                perishableParcelBox.getAllParcels();
                break;
        }
    }
}

