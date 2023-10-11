package Thread03;

import java.util.Scanner;

class Road {
    private String roadName;
    private String signal = "green";

    public Road(String roadName) {
        this.roadName = roadName;
    }

    public synchronized void drive(int carId) {
        while (!signal.equals("red")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(roadName +  "에 자동차" + carId + "가 주행합니다.");
        signal = "green";
        notify();
    }

    public synchronized void walk(int personId) {
        while (!signal.equals("green")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(roadName + "에서 보행자 " + personId + "가 걷는다.");
        signal = "red";
        notify();
    }

    public synchronized void rideBike(int bikeId) {
        while (!signal.equals("green")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(roadName + "에서 자전거 " + bikeId + "가 달린다.");
        signal = "red";
        notify();
    }
}

class Car extends Thread {
    private Road road;
    private int carId;

    public Car(int id, Road r) {
        carId = id;
        road = r;
    }

    public void run() {
        road.drive(carId);
    }
}

class Person extends Thread {
    private Road road;
    private int personId;

    public Person(int id, Road r) {
        personId = id;
        road = r;
    }

    public void run() {
        road.walk(personId);
    }
}

class Bike extends Thread {
    private Road road;
    private int bikeId;

    public Bike(int id, Road r) {
        bikeId = id;
        road = r;
    }

    public void run() {
        road.rideBike(bikeId);
    }
}

public class ThreeSignals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("도로를 이용할 자동차, 자전거, 보행자들이 몇 명씩인지 입력 ==> ");
        int cnt = s.nextInt();

        Road rd = new Road("명전대 사거리");
        Car car[] = new Car[cnt];
        Person man[] = new Person[cnt];
        Bike bike[] = new Bike[cnt];

        for (int i = 0; i < cnt; i++) {
            car[i] = new Car(i + 1, rd);
            man[i] = new Person(i + 1, rd);
            bike[i] = new Bike(i + 1, rd);
        }

        for (int i = 0; i < cnt; i++) {
            car[i].start();
            man[i].start();
            bike[i].start();
        }
    }
}
