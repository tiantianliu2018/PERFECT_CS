package practice.design;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个地铁系统
 *
 * @author Kelly
 * @create 2021-07-17 10:26
 */
public class T1396_DesignUndergroundSystem {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "a", 3);
        undergroundSystem.checkIn(32, "aa", 8);
        undergroundSystem.checkIn(27, "a", 10);
        undergroundSystem.checkOut(45, "ab", 15);
        undergroundSystem.checkOut(27, "ab", 20);
        undergroundSystem.checkOut(32, "b", 22);
        undergroundSystem.getAverageTime("aa", "b");
        undergroundSystem.getAverageTime("a", "ab");
        undergroundSystem.checkIn(10, "a", 24);
        undergroundSystem.getAverageTime("a", "ab");
        undergroundSystem.checkOut(10, "ab", 38);
        undergroundSystem.getAverageTime("a", "ab");

    }

    static class UndergroundSystem {
        Map<Integer, Pair<String, Integer>> inMap = new HashMap<>();
        // key 是入站和出站名称  value 保存有几个乘客属于这段路程与出行时间和
        Map<String, Pair<Integer, Double>> timeMap = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            // 有人进站的时候保存
            inMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> nameAndTime = inMap.get(id);
            String key = nameAndTime.getKey() + "-" + stationName;
            Pair<Integer, Double> pair = timeMap.getOrDefault(key, new Pair<>(0, 0.0));
            timeMap.put(key, new Pair<>((pair.getKey() + 1), pair.getValue() + t - nameAndTime.getValue()));
            inMap.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            Pair<Integer, Double> pair = timeMap.get(startStation + "-" + endStation);
            System.out.println(pair.getValue() / pair.getKey());
            return pair.getValue() / pair.getKey();
        }
    }
}
