package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Конвертер температури ===");
            System.out.println("1. Celsius (°C)");
            System.out.println("2. Fahrenheit (°F)");
            System.out.println("3. Kelvin (K)");
            System.out.println("0. Вихід");
            System.out.print("Оберіть початкову одиницю: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Помилка: введіть номер пункту.");
                scanner.next();
                continue;
            }

            int from = scanner.nextInt();

            if (from == 0) {
                System.out.println("Вихід. Дякуємо за використання!");
                break;
            }

            if (from < 1 || from > 3) {
                System.out.println("Помилка: невідомий пункт меню.");
                continue;
            }

            System.out.print("Оберіть одиницю для конвертації (1 - °C, 2 - °F, 3 - K): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Помилка: введіть номер пункту.");
                scanner.next();
                continue;
            }

            int to = scanner.nextInt();

            if (to < 1 || to > 3) {
                System.out.println("Помилка: невідома одиниця.");
                continue;
            }

            System.out.print("Введіть температуру: ");

            if (!scanner.hasNextDouble()) {
                System.out.println("Помилка: введіть число.");
                scanner.next();
                continue;
            }

            double value = scanner.nextDouble();
            double result;

            // Спочатку переводимо температуру в Celsius
            double celsius;

            if (from == 1) {
                celsius = value;
            } else if (from == 2) {
                celsius = (value - 32) * 5 / 9;
            } else {
                celsius = value - 273.15;
            }

            // Потім Celsius переводимо у потрібну одиницю
            if (to == 1) {
                result = celsius;
            } else if (to == 2) {
                result = celsius * 9 / 5 + 32;
            } else {
                result = celsius + 273.15;
            }

            System.out.printf("Результат: %.2f %s = %.2f %s%n",
                    value, getUnit(from), result, getUnit(to));
        }

        scanner.close();
    }

    public static String getUnit(int unit) {
        if (unit == 1) {
            return "°C";
        } else if (unit == 2) {
            return "°F";
        } else {
            return "K";
        }
    }
}