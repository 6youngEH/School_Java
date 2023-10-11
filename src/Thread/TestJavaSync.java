package Thread;

import java.util.Random;

class Professor {
    public synchronized void checkExam(String studentName, int examTime) {
        System.out.println(studentName + "가 시험본 시간은 " + examTime + "ms");
        System.out.println("안유정 교수가 " + studentName + "의 시험지를 확인하고 접수했다.");
    }
}

class Student extends Thread {
    private final String studentName;
    private final Professor professor;

    public Student(String studentName, Professor professor) {
        this.studentName = studentName;
        this.professor = professor;
    }

    @Override
    public void run() {
        int startTime = (int) System.currentTimeMillis();
        int randomExamTime = new Random().nextInt(10000);

        try {
            Thread.sleep(randomExamTime);
        } catch (InterruptedException e) {

        }

        int endTime = (int) System.currentTimeMillis();
        int examTime = endTime - startTime;

        System.out.println(studentName + "이(가) JAVA 시험을 보고있다");
        professor.checkExam(studentName, examTime);
        System.out.println(studentName + "이(가) 집으로 돌아간다.");
    }
}

public class TestJavaSync {
    public static void main(String[] args) {
        Professor professor = new Professor();
        Student student1 = new Student("2022081106번 유경태", professor);
        Student student2 = new Student("2022081123번 김용훈", professor);
        Student student3 = new Student("2020081107번 김응찬", professor);

        student1.start();
        student2.start();
        student3.start();
    }
}
