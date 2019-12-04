package stream;

import java.util.Arrays;
import java.util.List;

public class StreamDemoBetter {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("songjunbao", 20,98), new User("jianghua", 26,92));

        int sum = users.stream().filter(u -> u.getAge() <25).mapToInt(u -> u.getScore()).sum();

        System.out.println(sum);


    }

}
