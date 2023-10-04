package Exception;

class NoDateException extends Exception{}//데이터가 입력되지 않은 예외
class OperatorExcetpion extends Exception{}//연산자 예외
class InputException extends  Exception{}//수식의 형식이 잘못된 예외
public class ExceptionExample02 {
    static void checkNoData (int size) throws NoDateException
    {
        if(size == 0)//입력된 수식의 길이가 0이면 데이터가 입력되지 않은 예외
            throw new NoDateException();
    }
    static void checkExpression (int size) throws InputException
    {
        if(size != 3)//입력된 수식의 길이가 3이 아니면 수식의 형식이 잘못된 예외
            throw new InputException();
    }
    static void isOper(String op) throws OperatorExcetpion
    {
        if(!(op.equals("+")||op.equals("-")||op.equalsIgnoreCase("X")||op.equals("/")))throw new OperatorExcetpion();
    }
    static void calculate (String input[]){
        int num1 ,num2;
        String opr;
        double result;

        num1 = Integer.parseInt(input[0]);
        opr = input[1];
        num2 = Integer.parseInt(input[2]);

        if (opr.equals("+")) result = num1 + num2;
        else if (opr.equals("-")) result = num1 - num2;
        else if (opr.equals("x")||opr.equals("X")) result = num1 * num2;
        else result = num1 /num2;
        System.out.println(num1 + opr + num2 +"="+result );

    }


    public static void main(String[] args) {
        try {
            checkNoData(args.length);
            checkExpression(args.length);
            isOper(args[1]);
            calculate(args);
        }catch (NoDateException nd){
            System.out.println("사칙연산 수식을 입력해주세요!!");
        }catch (InputException ie){
            System.out.println("수식입력을 이와같이 해주세요 => <숫자><연산자><숫자>");
        }catch (NumberFormatException nfe){
            System.out.println("피연산자는 숫자만 들어올 수 있습니다.!! ex)<숫자><연산자(+,-,x,/)<숫자>");
        }catch (OperatorExcetpion oe){
            System.out.println("연산은 사칙 연산만 가능합니다.!ex)<숫자><연산자(+,-,x,/)<숫자>");
        }

    }
}
