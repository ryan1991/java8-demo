package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "bc", "bc", "efg", "abcd","abc", "jkl");

        List<String> distinct = strings.parallelStream().distinct().collect(Collectors.toList());
        System.out.println(distinct);


        System.out.println("system env :" +System.getenv());
        System.out.println("system props :" +System.getProperties());

    }

}
