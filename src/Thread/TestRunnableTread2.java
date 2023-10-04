package Thread;
class RunnableTread2 implements Runnable {
    String name;
    RunnableTread2(String s){
        name = s;
    }
    public void run(){
        for(int i = 0;i < 5;i++)
            System.out.println(name +"실행중");
    }
}

public class TestRunnableTread2 {
    public static void main(String[] args) {
        RunnableTread2 r = new RunnableTread2("첫번째 스레드");
        Thread t1 = new Thread(r);
        RunnableTread2  r2 =new RunnableTread2("두번째 스레드");
        Thread t2 = new Thread(r2);
        System.out.println("스레드 시작 전");
        t1.start();
        t2.start();
        System.out.println("스레드 시작 후");
    }
}
