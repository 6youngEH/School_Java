package Thread;

class Printer{
    static  int num = 0;
    synchronized void printing(String name){
        System.out.println(name + "가" + num++ + "번째로 프린터 출력");
    }
}
class PC extends Thread{
    Printer sp;
    PC(Printer p, String name){
        super(name);
        sp = p;
    }
    public void run() {
        for(int i = 0; i<3; i++)
            sp.printing(getName());
    }
}
public class SyncPCThread {
    public static void main(String[] args) {
        Printer printer = new Printer();
        PC c1 = new PC(printer, "첫번째 컴퓨터");
        PC c2 = new PC(printer, "두번째 컴퓨터");
        PC c3 = new PC(printer, "세번째 컴퓨터");
        c1.start();
        c2.start();
        c3.start();
    }
}
