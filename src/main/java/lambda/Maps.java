package lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Maps {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("abc", "acb", "adc", "cba", "dcfd");


        Map<String, Counter> countMap = new HashMap<>();

        words.forEach(word -> {
            String newWord = ascWord(word);
            countMap.computeIfAbsent(newWord ,(x) -> new Counter()).add();
        });

        System.out.println(countMap);

        Map<String, Integer> groupMap = words.stream().collect(Collectors.groupingBy(Maps::ascWord, Collectors.summingInt((x) -> 1)));
        System.out.println(groupMap);


        Map<Boolean, List<String>> partMap = words.stream().collect(Collectors.partitioningBy(word -> word.length()> 3));
        System.out.println(partMap);
    }

    private static class Counter{
        private int count = 0;

        public Counter(){

        }

        public void add(){
            count++;
        }

        @Override
        public String toString() {
            return count +"";
        }
    }


    private static String ascWord(String word){
       char[] chars = word.toCharArray();
       Arrays.sort(chars);
       return new String(chars);
    }

}
