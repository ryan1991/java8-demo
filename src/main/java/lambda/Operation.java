package lambda;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    ADD,
    DELETE,
    UPDATE,
    QUERY;

    public static Map<String, Operation> stringToEnum(){
        /**
         * toMap 映射收集器
         */
        return Stream.of(values()).collect(Collectors.toMap(Objects::toString, e ->e));
    }


    public static void main(String[] args) {
        System.out.println(stringToEnum());


    }
}
