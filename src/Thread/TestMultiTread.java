package Thread;
class ThreadA extends Thread{
    public static int num = 0;
    public ThreadA(String name){
        super(name);
    }
    public void run(){
        for(int i =0;i <10;i++)
            System.out.println(num++ +" : "+getName());
    }
}

public class TestMultiTread {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("첫번째 스레드");
        ThreadA t2 = new ThreadA("두번째 스레드");
        t1.start();
        t2.start();
    }
}
