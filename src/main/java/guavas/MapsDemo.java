package guavas;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

public class MapsDemo {

    public static void main(String[] args) {

        Map<String, Set<String>> dbTablesMap = Maps.newHashMap();
        Set<String> set1 = Sets.newHashSet("t_db","t_instance","t_table");
        Set<String> set2 = Sets.newHashSet("t_user","t_user_attr");
        dbTablesMap.put("maserati_web", set1);
        dbTablesMap.put("user", set2);

        Map<String, String> map = Maps.transformEntries(dbTablesMap, (k, v) -> {return Joiner.on(",").join(v);});
        System.out.println(map);
    }





}
