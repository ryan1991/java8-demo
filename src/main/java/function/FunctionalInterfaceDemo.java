package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为 lambda 表达式
 *
 * JDK1.8之前增加的函数式接口：java.lang.Runnable，java.util.concurrent.Callable，
 * java.security.PrivilegedAction，java.util.Comparator，java.io.FileFilter
 * java.nio.file.PathMatcher，java.lang.reflect.InvocationHandler，java.beans.PropertyChangeListener，
 * java.awt.event.ActionListener，javax.swing.event.ChangeListener
 *
 * JDK 1.8 新增加的函数接口： java.util.function包下的接口
 **/
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出全部");
        eval(list, n -> true);
        System.out.println("");
        System.out.println("输出偶数");
        eval(list, n -> n % 2 == 0);
        System.out.println("");
        System.out.println("输出>3的数");
        eval(list, n -> n > 3);

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for (Integer n: list) {
            if (predicate.test(n)){
                System.out.print(n + " ");
            }

        }

    }

}
