package guavas;

import com.google.common.collect.Sets;

import java.util.Set;

public class GuavaSets {
    public static void main(String[] args) {
        Set<Integer> sets = Sets.newHashSet(3,4);
        Set<Integer> sets2 = Sets.newHashSet(3);
        // 交集
        System.out.println("交集为：");
        Sets.SetView<Integer> intersection = Sets.intersection(sets, sets2);

            System.out.println(intersection);





        String[] arr1 = {"a", "b", "c"};
        String[] arr2 = {"a", "b", "d"};
        Set<String> set1 = Sets.newHashSet(arr1);
        Set<String> set2 = Sets.newHashSet(arr2);

        Sets.SetView<String> intersect = Sets.intersection(set1, set2);
        Sets.SetView<String> diff = Sets.difference(set1, set2);
        Sets.SetView<String> union= Sets.union(set1, set2);
        System.out.println(intersect);
        System.out.println(diff);
        System.out.println(union);




    }


}
