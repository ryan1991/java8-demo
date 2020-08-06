package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {

        rightToArray();


    }

    private static void errorToArray(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        /**
         *  会报错 java.lang.ClassCastException: java.lang.Object[] cannot be cast to java.lang.String[]
         */
        String[] strings1 = (String[]) list.toArray();
//        String[] stirngs2 = list.toArray(new String[0]);//最佳解决方式
    }

    private static void rightToArray(){
        List<String> list = Arrays.asList("张三","李四");
        String[] strings1 = (String[]) list.toArray();
    }


}
