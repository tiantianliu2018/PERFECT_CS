package competition.Week198;

/**
 * @author Kelly
 * @create 2020-07-19 10:22
 */
public class T1 {
    public static void main(String[] args) {
        int res = numWaterBottles(2, 3);
        System.out.println(res);
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= 3) {
            int temp = numBottles / numExchange;
            if (temp == 0) break;
            int remian = numBottles % numExchange;
            res += temp;
            numBottles = temp + remian;
        }
        return res;
    }
}
