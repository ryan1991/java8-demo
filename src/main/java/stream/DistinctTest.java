package stream;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "bc", "bc", "efg", "abcd","abc", "jkl");

        List<String> distinct = strings.parallelStream().distinct().collect(Collectors.toList());
        System.out.println(distinct);


        System.out.println("system env :" + JSON.toJSONString(System.getenv()));
        System.out.println("system props :" +JSON.toJSONString(System.getProperties()));

        int SYN_CONSUMER_LOCK_SIZE = 1 << 5;
        System.out.println(SYN_CONSUMER_LOCK_SIZE);

    }

}
