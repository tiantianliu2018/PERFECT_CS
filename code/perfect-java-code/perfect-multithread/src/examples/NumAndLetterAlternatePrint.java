package examples;

/**
 * @author Kelly
 * @create 2020-08-23 10:06
 * 交替打印数字和字母：12A34B56C...
 */
public class NumAndLetterAlternatePrint {
    private boolean flag;
    private int count;

    public synchronized void printNum() {
        for (int i = 0; i < 26; i++) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(++count);
            System.out.print(++count);
            flag = !flag;
            notify();
        }
    }
    public synchronized void printLetter() {
        for (int i = 0; i < 26; i++) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print((char) (i + 65));
            flag = !flag;
            notify();
        }
    }

    public static void main(String[] args) {
        NumAndLetterAlternatePrint print = new NumAndLetterAlternatePrint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                print.printNum();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                print.printLetter();
            }
        }).start();
    }
}
