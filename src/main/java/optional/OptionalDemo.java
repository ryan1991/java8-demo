package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author ryan.song
 * @Date 2019/2/12
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a, b));

        Map<String, Object> logMap = new HashMap<>();
        Map<String, String> ext = new HashMap<>();
        ext.put("a", "a");
        Optional.ofNullable(ext).ifPresent(logMap::putAll);

        System.out.println(logMap);

    }


    public static Integer sum(Optional<Integer> a, Optional<Integer> b){
        // Optional.isPresent - 判断值是否存在
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}
