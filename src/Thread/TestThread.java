package Thread;
class ThreadExample extends Thread{
    public ThreadExample(String name){
        super(name);
    }
    public void run(){
        System.out.println(getName()+"실행중입니다.");
    }
}
public class TestThread {
    public static void main(String[] args) {
        ThreadExample t = new ThreadExample("자바 스레드");
        System.out.println("스레드 시작 전");
        t.start();
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
