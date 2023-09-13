package Ukt99;

abstract class Computer {
    protected String name;
    protected String grade;

    public Computer(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    abstract void programming();

    void liberal(String subject) {
        System.out.println(grade + name + "가 " + subject + " 수업을 듣는다");
    }
}

class Freshman extends Computer {
    public Freshman(String name, String grade) {
        super(name, grade);
    }

    @Override
    void programming() {
        System.out.println(grade + name + "가 C언어를 수강한다");
    }

}

class Sophomore extends Computer {
    public Sophomore(String name, String grade) {
        super(name, grade);
    }

    @Override
    void programming() {
        System.out.println(grade + name + "가 Java를 수강한다");
    }
    void liberal(String subject){
        System.out.println(grade + name + "가 교양으로" + subject + " 를 수강한다.");
    }
}

public class Test06 {
    public static void main(String[] args) {
        Freshman s1 = new Freshman("김명지", "1학년");
        s1.programming();
        s1.liberal("영어회화");

        Sophomore s2 = new Sophomore("이준호", "2학년");
        s2.programming();
        s2.liberal("수학");
    }
}


