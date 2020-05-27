package lambda;

import com.google.common.base.Joiner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LongStreams {

    public static void main(String[] args) {

        List<Long> collect = LongStream.range(0, 100).boxed().collect(Collectors.toList());
        System.out.println(Joiner.on(",").join(collect));


    }

}
