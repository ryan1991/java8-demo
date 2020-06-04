package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemoBetter {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("songjunbao", 20,98), new User("jianghua", 26,92), new User("xiaobao", 26,92));

        List<String> name = users.stream().filter(u -> u.getScore() > 95).map(User::getName).collect(Collectors.toList());
        List<Integer> nameLength = users.stream().filter(u -> u.getScore() > 95).map(User::getName).map(String::length).collect(Collectors.toList());
        System.out.println("name:" + name);
        System.out.println("nameLength:" + nameLength);
        int sum = users.stream().filter(u -> u.getAge() <25).mapToInt(u -> u.getScore()).sum();
        System.out.println("sum:" + sum);

        Map<Integer, List<String>> ageNameMap = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
        System.out.println("ageNameMap:"  + ageNameMap);

    }

}
