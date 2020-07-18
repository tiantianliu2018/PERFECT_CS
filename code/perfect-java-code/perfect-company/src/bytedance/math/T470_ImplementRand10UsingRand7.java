package bytedance.math;

import org.omg.CORBA.INTERNAL;

/**
 * @author Kelly
 * @create 2020-07-12 16:48
 *
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，
 * 试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 生成 rand10()  [1,10]
 * 利用公式 （randN() - 1） * N + randN()   [1,49]
 * 其中 1-40 可以组成 10 的倍数  通过 num % 10 + 1 可以获得，41-49 舍去
 */
public class T470_ImplementRand10UsingRand7 {
    public int rand10() {
        int num = 0;
        while (true) {
            num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) break;
        }
        return num % 10 + 1;
    }

    public int rand7(){
        return 0;
    }

}
