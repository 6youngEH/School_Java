package Thread;
import java.util.Scanner;

class Vote_PlaceN {
    private String Placename;

    public Vote_PlaceN(String Placename) {
        this.Placename = Placename;
    }

    synchronized void id(String num, String name) {
        System.out.println(Placename + "에서 주민번호 : " + num + ", 이름 : " + name + " 신분확인합니다");
    }

    synchronized void vote(String num, String name) {
        System.out.println(Placename + "에서 주민번호 : " + num + ", 이름 : " + name + " 이(가) 투표합니다.");
    }

    void putin(String num, String name) {
        System.out.println(Placename + "에서 주민번호 : " + num + ", 이름 : " + name + "이(가) 투표지를 투표함에 넣습니다.");
    }
}

class PeopleN extends Thread {
    private String num;
    private String name;
    private Vote_PlaceN Placename;

    public PeopleN(String num, String name, Vote_PlaceN Placename) {
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

public class Vote_ProgramN {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("투표소가 설치된 동 이름을 입력하세요.");
        String place = s.next();
        Vote_PlaceN vp = new Vote_PlaceN(place); // 투표소 객체 생성
        System.out.print(place + " 투표소의 총 유권자 수를 정수로 입력하세요.");
        int cnt = s.nextInt();
        PeopleN[] p = new PeopleN[cnt]; // PeopleN 객체 배열 생성

        for (int i = 0; i < cnt; i++) {
            System.out.println("투표할 유권자가 있으면 1, 더 이상 없으면 0을 입력하세요.");
            int n = s.nextInt();

            if (n == 1) {
                System.out.print("유권자의 주민번호와 이름을 입력하세요: ");
                String num = s.next();
                String name = s.next();
                p[i] = new PeopleN(num, name, vp); // PeopleN 객체 생성
                p[i].start(); // 스레드 시작
            } else if (n == 0) {
                break;
            } else {
                System.out.println("1 또는 0을 입력해주세요.");
                i--; // 다시 입력 받도록 인덱스를 하나 줄입니다.
            }
        }
    }
}
