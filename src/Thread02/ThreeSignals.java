package Thread02;

import java.util.Scanner;

class Car extends Thread{
    private Road road;

    public Car(Road r){
        road r;
    }
    public void run(){
        road.drive();
    }
}
class Person extends Thread{

}
public class ThreeSignals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("도로를 이용할 자동차, 자전거, 보행자들이 몇명씩인지 입력 ==> ");
        int cnt = s.nextInt();
        Person man[] = new Person[cnt];
        Bike bike[] = new Bike[cnt];
        Car car[] = new Car[cnt];

        Roads rd = new Roads("명전대 사거리");

        for (int i = 0; i<cnt; i++) {
            man[i] = new Person(i+1, rd);
            bike[i] = new Bike(i+1,rd);
            car[i] = new Car(i+1,rd);
        }
        for (int i = 0; i < cnt; i++){
            man[i].start();
            bike[i].start();
            car[i].start();
        }
    }
}
