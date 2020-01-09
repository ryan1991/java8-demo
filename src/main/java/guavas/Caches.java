package guavas;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import model.Person;

import java.util.concurrent.TimeUnit;

public class Caches {

    private static Cache<String, Person> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(100, TimeUnit.MILLISECONDS).build();

    public static void main(String[] args) throws Exception{

        Person p1 = getPerson("songjunbao");
//        Thread.sleep(1000L);
        Person p2 = getPerson("songjunbao");
        System.out.println(p1 == p2);



    }

    private static Person getPerson(String name){
       Person person = cache.getIfPresent(name);
       if (person == null){
           person = new Person(name, 20);
           cache.put(name, person);
       }

       return person;
    }


}
