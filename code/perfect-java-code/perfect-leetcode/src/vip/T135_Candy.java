package vip;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-07-04 15:34
 *
 * 有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *  每个孩子至少分配到 1 个糖果。
 *  相邻的孩子中，评分高的孩子必须获得更多的糖果
 * 老师至少需要准备多少颗糖果呢？
 */
public class T135_Candy {
    /**
     * 暴力解法
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        boolean change = true;  // 变量，标记 candies 是否变化
        int sum = 0;
        while (change) {
            change = false;
            for (int i = 0; i < n; i++) {
                if (i != n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    change = true;
                }
                if (i != 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    change = true;
                }
            }
        }
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    /**
     * 拆成两个数组，每次只看一边
     * 从左到右遍历一次，从右到左遍历一次，取两个数组中较大的一个
     */
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] left2right = new int[n];
        int[] right2left = new int[n];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1] && left2right[i] <= left2right[i-1]) {
                left2right[i] = left2right[i-1] + 1;
            }
        }
        for (int i = n - 2; i >= 0 ; i--) {
           if (ratings[i] > ratings[i + 1] && right2left[i] <= right2left[i + 1]) {
               right2left[i] = right2left[i + 1] + 1;
           }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(left2right[i], right2left[i]);
        }
        return res;
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int res = 0;
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }

}
