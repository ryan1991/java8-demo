package lambda;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import java.util.*;
import java.util.stream.Collectors;

public class Maps {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("abc", "acb", "adc", "cba", "dcfd");

        Multimap<Integer, String> multimap = ArrayListMultimap.create();
        words.forEach(w -> multimap.put(w.length(), w));

        Map<Integer, List<String>> lengthWordMap = new HashMap<>();
        words.forEach(w -> {
            lengthWordMap.computeIfAbsent(w.length(), x -> new ArrayList<>()).add(w);
        });
        System.out.println("multimap:" + multimap);
        System.out.println("lengthWordMap:" + lengthWordMap);



        Map<String, Counter> countMap = new HashMap<>();

        words.forEach(word -> {
            String newWord = ascWord(word);
            countMap.computeIfAbsent(newWord ,(x) -> new Counter()).add();
        });

        System.out.println(countMap);

//        Map<String, Integer> groupMap = words.stream().collect(Collectors.groupingBy(Maps::ascWord, Collectors.summingInt((x) -> 1)));
        Map<String, Long> groupMap = words.stream().collect(Collectors.groupingBy(Maps::ascWord, Collectors.counting()));
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
