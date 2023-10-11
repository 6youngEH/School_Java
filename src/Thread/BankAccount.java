package Thread;
class Minus_Remain extends Exception{}//출금시 예금잔액 부족한 예외클래스 생성
class Account{//공유자원인 통장 class 생성
    private int total_money = 0;
    synchronized void deposit(String name, int money){
        total_money += money;
        System.out.println(name + "이" + money + "입금하여 잔액은" + total_money + "원");
    }
    synchronized void withdrawal(String name, int money)throws Minus_Remain{
        if(total_money-money<0)
            throw new Minus_Remain();
        total_money = total_money - money;
        System.out.println(name + "이" +money+ "출금하여 잔액은" + total_money + "원");
    }
}
class Man extends Thread {
    Account account;

    Man(Account act, String name) {
        super(name);
        account = act;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                account.deposit(getName(), 1000);
                account.withdrawal(getName(), 100);
            }
        } catch (Minus_Remain e) {
            System.out.println(e + "출금하려하나 통장 잔액이 부족해요");
        }
    }
}

    public class BankAccount {
        public static void main(String[] args) {
            Account tongjang = new Account();
            Man m1 = new Man(tongjang, "첫번째 사람");
            Man m2 = new Man(tongjang, "두번째 사람");
            Man m3 = new Man(tongjang, "세번째 사람");
            m1.start();
            m2.start();
            m3.start();

        }
    }

