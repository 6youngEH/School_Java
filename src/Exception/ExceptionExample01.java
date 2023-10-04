package Exception;


import java.util.InputMismatchException;
import java.util.Scanner;
class MinusException extends Exception{}
class OverFlowException extends Exception{}

public class ExceptionExample01 {
    public static void main(String[] args) {
        int score;
        try {
            Scanner s = new Scanner(System.in);
            score = s.nextInt();
            if (score < 0) {
                throw new MinusException();
            } else if (score > 100) {
                throw new OverFlowException();
            }

        } catch (MinusException e) {
            System.out.println("음수는 값으로 들어올 수 없습니다.");
        } catch (OverFlowException e) {
            System.out.println("100보다 큰값은 들어올 수 없습니다.");
        }catch(InputMismatchException e){
            System.out.println("점수는 정수만 입력 가능합니다.");
        }

    }

}
