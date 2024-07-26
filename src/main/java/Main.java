import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for (int j = 0; j < 3; j++) {

            System.out.println("Введите название машины № " + (j + 1));
            String name = scanner.next();

            System.out.println("Введите скорость машины № " + (j + 1));
            int speed = 0;

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();

                    if (speed >= 0 && speed <= 250) {
                        break;
                    }
                    else {
                        System.out.println("Введите корректное значение скорости от 0 до 250 км/час");
                    }
                }
                else {
                    String s = scanner.next();
                    System.out.println("Введите корректное значение");
                }
            }

            cars[j] = new Car(name, speed);
        }
        scanner.close();

        String winner = cars[0].name;
        int winDistance = cars[0].countDistance();

        for (int i = 0; i < 3; i++) {

            if (cars[i].countDistance() > winDistance) {
                winDistance = cars[i].countDistance();
                winner = cars[i].name;
            }
        }
        System.out.println("Победитель гонки: " + winner);
    }
}


class Car {

    String name;
    int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    int distance = 0;

    int countDistance() {
        distance = 24 * speed;
        return distance;
    }
}