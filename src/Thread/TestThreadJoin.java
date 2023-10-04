package Thread;
class ThreadExample1 extends Thread {
    public ThreadExample1(String name){
        super(name);
    }
    public void run(){
        System.out.println(getName()+"실행중입니다.");
    }
}

public class TestThreadJoin {
    public static void main(String[] args) {
        ThreadExample t = new ThreadExample(("자바 스레드"));
        System.out.println("스레드 시작 전");
        t.start();
        try {
            t.join();
        } catch (Exception e) {
            System.out.println("join 실행중 예외 발생");
        }
        System.out.println("스레드 시작 후1");
        System.out.println("스레드 시작 후2");
        System.out.println("스레드 시작 후3");
        System.out.println("스레드 시작 후4");
        System.out.println("스레드 시작 후5");
        System.out.println("스레드 시작 후6");
        System.out.println("스레드 시작 후7");
        System.out.println("스레드 시작 후8");
        System.out.println("스레드 시작 후9");
        System.out.println("스레드 시작 후10");

    }
}
