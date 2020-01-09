package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Maps2 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("a", "b","c", "b","c","b");

        Map<String,Long> map  = words.stream().collect(groupingBy(word -> word, counting()));
        System.out.println(map);


       String wordStr = words.stream().collect(joining(","));
        System.out.println(wordStr);


    }

}
