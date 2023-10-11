package Thread02;

class Cars extends Thread {
    private Road road;

    public Cars(Road r) {
        road = r;
    }

    public void run() {
        road.drive();
    }
}

class People extends Thread {
    private Road road;

    public People(Road r) {
        road = r;
    }

    public void run() {
        road.walk();
    }
}

class Road {
    private String signal = "green";
    String road_name;

    Road(String rn) {
        road_name = rn;
    }

    public synchronized void drive() {
        while (!signal.equals("red")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(road_name + "에 차가 주행한다.");
        signal = "green";
        notify();
    }

    public synchronized void walk() {
        while (!signal.equals("green")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(road_name + "에서 사람이 걷는다.");
        signal = "red";
        notify();
    }
}

public class Twosignal {
    public static void main(String[] args) {
        Road rd = new Road("명전대 사거리");
        People man = new People(rd);
        Cars car = new Cars(rd);
        man.start();
        car.start();
    }
}
