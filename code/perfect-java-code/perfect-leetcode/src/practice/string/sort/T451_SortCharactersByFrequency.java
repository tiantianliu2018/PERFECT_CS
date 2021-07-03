package practice.string.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kelly
 * @create 2020-09-24 09:47
 * <p>
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class T451_SortCharactersByFrequency {
    /**
     * map 统计字符出现的频率，设置多个桶，每个桶的下标对应字符出现的频率
     * 然后遍历这些桶
     */
    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        // 建立多个频率桶
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character c : charMap.keySet()) {
            int frequency = charMap.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }
        // 遍历这些桶，得到结果
        char[] chars = new char[s.length()];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) continue;
            for (Character c : buckets[i]) {
                // i 表示当前元素出现的频率，因此要将所有元素添加 i 个
                for (int j = 0; j < i; j++) {
                    chars[idx++] = c;
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String res = frequencySort("tree");
        System.out.println(res);

        System.out.println(frequencySort1("tree"));
    }

    public static String frequencySort1(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        // map 存储当前字母以及出现的次数
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        // 根据 value 倒序排序
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        charMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        // 根据 sortedMap 构造字符串
        StringBuilder sb = new StringBuilder();
        for (Character c : sortedMap.keySet()) {
            int count = sortedMap.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
