package others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Foreachs {
    public static void main(String[] args) {

        List<String>  words = Arrays.asList("a", "b", "c");
//        words.forEach(w ->{
//                    System.out.println(w);
//                    return;
//        });


        for (String w: words) {
            System.out.println(w);
            break;
        }


        Integer a = 128;
        Integer b = new Integer(127);

        Integer c = Integer.valueOf(128);


        System.out.println(a.equals(c) );


        Stream<String> stream = words.stream();
        stream.forEach(System.out::println);
        //流只能遍历一次，遍历完流就消费掉了
        stream.forEach(System.out::println);

    }


}
