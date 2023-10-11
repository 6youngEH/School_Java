package Thread;
import java.util.Random;

class Ball {
    private int scoreFirstPlayer = 0;
    private int scoreSecondPlayer = 0;

    synchronized void catchBall(String playerName) {
        System.out.println(playerName + "이(가) 공을 잡습니다.");
    }

    synchronized void dribble(String playerName) {
        System.out.println(playerName + "이(가) 드리블합니다.");
    }

    synchronized void shoot(String playerName) {
        System.out.println(playerName + "이(가) 슛을 던집니다.");
        if (playerName.equals("1번 첫번째 선수")) {
            scoreFirstPlayer++;
            System.out.println("1번 첫번째 선수 현재 점수: " + scoreFirstPlayer);
        } else if (playerName.equals("2번 두번째 선수")) {
            scoreSecondPlayer++;
            System.out.println("2번 두번째 선수 현재 점수: " + scoreSecondPlayer);
        }
    }

        void result() {
        System.out.println("경기 결과는" + scoreFirstPlayer + ":" + scoreSecondPlayer);
    }
}

class Player extends Thread {
    private Ball ball;
    private String playerName;
    private int playerNumber;

    public Player(Ball ball, String playerName, int playerNumber) {
        this.ball = ball;
        this.playerName = playerName;
        this.playerNumber = playerNumber;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int motion = random.nextInt(3);

            switch (motion) {
                case 0:
                    ball.catchBall(playerName);
                    break;
                case 1:
                    ball.dribble(playerName);
                    break;
                case 2:
                    ball.shoot(playerName);
                    break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PlayBall2 {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Player first = new Player(ball, "1번 첫번째 선수", 1);
        Player second = new Player(ball, "2번 두번째 선수", 2);

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (Exception e) {}
        ball.result();
    }
}
