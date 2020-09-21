package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 笛卡尔积
 * @author songjunbao
 * @date 2020-08-27
 */
public class Descartes {
    public static void main(String[] args) {
        List<List<String>> listData = new ArrayList<>();
        listData.add(Arrays.asList("1", "2"));
        listData.add(Arrays.asList("ios", "android"));
        listData.add(Arrays.asList(null, "5.6.0", "5.6.1", "6.0.0"));
        listData.add(Arrays.asList(null , "AppColdLau", "Order", "GOD"));
        listData.add(Arrays.asList(null , "end"));
        List<List<String>> lisReturn = getDescartes(listData);
        System.out.println("list.size:" + lisReturn.size());
        System.out.println("list" + lisReturn);


    }

    private static <T> List<List<T>> getDescartes(List<List<T>> list) {
        List<List<T>> returnList = new ArrayList<>();
        descartesRecursive(list, 0, returnList, new ArrayList<T>());
        return returnList;

    }
        /**
         * 递归实现
         * 原理：从原始list的0开始依次遍历到最后
         *
         * @param originalList 原始list
         * @param position     当前递归在原始list的position
         * @param returnList   返回结果
         * @param cacheList    临时保存的list
         */
    private static <T> void descartesRecursive(List<List<T>> originalList, int position, List<List<T>> returnList, List<T> cacheList) {
        List<T> originalItemList = originalList.get(position);
        for (int i = 0; i < originalItemList.size(); i++) {
            //最后一个复用cacheList，节省内存
            List<T> childCacheList = (i == originalItemList.size() - 1) ? cacheList : new ArrayList<>(cacheList);
            childCacheList.add(originalItemList.get(i));
            if (position == originalList.size() - 1) {//遍历到最后退出递归
                returnList.add(childCacheList);
                continue;
            }
            descartesRecursive(originalList, position + 1, returnList, childCacheList);
        }
    }

}
