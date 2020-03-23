package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 一言以蔽之，flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接 起来成为一个流。
 */
public class FlatMaps {
    public static void main(String[] args) {

        //目的 {"Hello", "World"} -> ["H","e","l","o","W","r","d"]
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> collect = words.stream()
                .map(word -> word.split("")) // 映射String[]
                .distinct().collect(Collectors.toList());

        System.out.println(collect);
        List<String> collect2 = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect2);

    }

}
