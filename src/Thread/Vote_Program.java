package Thread;

class Vote_Place {
    private String Placename;

    public Vote_Place(String Placename) {
        this.Placename = Placename;
    }

    synchronized void id(String num, String name) {
        System.out.println(Placename + "에서 주민번호 : " + num + ", 이름 : " + name + " 신분확인한다");
    }

    synchronized void vote(String num, String name) {
        System.out.println(Placename + "에서 주민번호 : " + num + ", 이름 : " + name + " 이(가) 투표합니다.");
    }

    void putin(String num, String name) {
        System.out.println(Placename + "에서 주민번호 : " + num + ", 이름 : " + name + "이(가) 투표지를 투표함에 넣습니다.");
    }


}

class People extends Thread {
    private String num;
    private String name;
    private Vote_Place Placename;

    public People(String num, String name, Vote_Place Placename) {
        this.num = num;
        this.name = name;
        this.Placename = Placename;
    }

    @Override
    public void run() {
        Placename.id(num, name);
        Placename.vote(num, name);
        Placename.putin(num, name);
    }
}

public class Vote_Program {
    public static void main(String[] args) {
        Vote_Place place = new Vote_Place("홍은동"); // 공유 자원 (기표소)
        People p1 = new People("990302-1034516", "김철수", place); // 스레드 유권자 객체(주민번호, 이름, 기표소)
        People p2 = new People("010622-4141516", "이영희", place);
        People p3 = new People("011225-3034512", "홍길동", place);
        p1.start();
        p2.start();
        p3.start();
    }
}
