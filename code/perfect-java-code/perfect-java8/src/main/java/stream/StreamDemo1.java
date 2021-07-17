package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kelly
 * @create 2021-07-07 20:48
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> players = Arrays.asList("Kobe", "James", "curry", "tom", "cat");

        List<String> filteredPlayers = players.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(filteredPlayers);
    }
}
