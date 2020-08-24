package examples;

import java.util.Objects;

/**
 * @author Kelly
 * @create 2020-08-24 09:44
 */
class Bank {
    static double money = 10000;
    // 柜台取钱
    private void counter(double mon) {
        Bank.money -= mon;
        System.out.println("柜台取钱 " + mon + " 元，还剩 " + money);
    }

    private void ATM(double mon){
        Bank.money -= mon;
        System.out.println("ATM 取钱 " + mon + " 元，还剩 " + money);
    }
    // 对外的取钱方法
    public synchronized void outMoney(double mon, String mode) throws Exception {
        if (mon > Bank.money) {
            throw new Exception("取钱金额为：" + mon + "，余额为：" + Bank.money + "，余额不足，取钱失败！");
        }
        if (Objects.equals(mode, "ATM")) {
            ATM(mon);
        } else {
            counter(mon);
        }
    }


}
class PersonA implements Runnable {
    Bank bank;
    String mode;
    public PersonA(Bank bank, String mode){
        this.bank = bank;
        this.mode = mode;
    }
    @Override
    public void run() {
        while (bank.money >= 100) {
            try {
                Thread.sleep(100);
                bank.outMoney(100, mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class PersonB implements Runnable {
    Bank bank;
    String mode;
    public PersonB(Bank bank, String mode) {
        this.bank = bank;
        this.mode = mode;
    }
    @Override
    public void run() {
        while (bank.money >= 200) {
            try {
                Thread.sleep(100);
                bank.outMoney(200, mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
public class GetMoneyDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        PersonA a = new PersonA(bank, "柜台");
        PersonB b = new PersonB(bank, "ATM");
        new Thread(a).start();
        new Thread(b).start();
    }
}
