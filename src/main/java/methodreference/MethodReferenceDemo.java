package methodreference;

import java.util.*;
import java.util.function.Supplier;

/**
 *
 *  方法引用Demo
 *
 **/
public class MethodReferenceDemo {

    public static void main(String[] args) {


        Person[] persons = new Person[]{new Person("songjunbao", 20),
                new Person("jianghua", 18),
                new Person("songxiyu", 1)};


        //静态方法引用
        Arrays.sort(persons, Person::compareByAge);
        System.out.println("static method reference:" + Arrays.toString(persons));


        //引用对象的实例方法
        ComparisonProvider provider = new ComparisonProvider();
        Arrays.sort(persons, provider::compareByAge);
        System.out.println("object instance-method reference:" + Arrays.toString(persons));



        //引用类的实例方法
        String[] stringsArray = new String[]{"ddd", "bbb", "ccc"};
        Arrays.sort(stringsArray, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(stringsArray));



        //引用的是构造方法
        final List<Person> personList = Arrays.asList(persons);
        //使用lambda表达式
        Set<Person> personSet = transferElements(personList,()-> new HashSet<>());
        System.out.println("personSet:" + personSet);
        Set<Person> personSet2 = transferElements(personList, HashSet::new);
        System.out.println("personSet2:" + personSet2);


    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceColletions, Supplier<DEST> colltionFactory) {
        DEST result = colltionFactory.get();
        for (T t : sourceColletions) {
            result.add(t);
        }
        return result;
    }


}
