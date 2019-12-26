package lambda;

import java.util.Arrays;
import java.util.List;

public class StreamMap {
    public static void main(String[] args) {

        final String prefix = "destination-";
        List<String> destList = Arrays.asList("destination-1576579890056","destination-88", "destination-22");

        Long max = destList.stream().map(x -> Long.valueOf(x.substring(prefix.length())))
                .filter(x -> x<50).max(Long::compareTo).get();

        System.out.println(max);


    }



}
