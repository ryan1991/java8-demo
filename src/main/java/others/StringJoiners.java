package others;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringJoiners {

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(",","{","}");

        String[] arr = {"a", "b", "c"};

        Arrays.stream(arr).forEach(s ->joiner.add(s));

        System.out.println(joiner.toString());



    }


}
