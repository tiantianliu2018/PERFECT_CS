package practice.greedy;

/**
 * @author Kelly
 * @create 2020-09-25 09:45
 *
 * 规则：花卉不能种植在相邻的地块上
 * 给定一个花坛（表示为一个数组包含 0 和 1，其中 0 表示没种植花，1 表示种植了花），和一个数 n 。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回 True，不能则返回 False。
 */
public class T605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0 || flowerbed.length < n) return false;
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            // 相邻两个位置没有种花，那么可以在该位置种花，如果是第一个或者最后一个位置，只需要看一侧
            if (flowerbed[i] == 1) continue;
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                n--;
                if (n <= 0) return true;
                flowerbed[i] = 1;
            }
        }
        return false;
    }
}
