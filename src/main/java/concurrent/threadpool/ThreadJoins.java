package concurrent.threadpool;

import java.util.stream.IntStream;

public class ThreadJoins {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            IntStream.range(0, 1000).forEach(i -> {
                 System.out.println("i:" + i);
                }
            );
        });

        t.start();
        //当前线程等待Join线程执行完成
        t.join();

        System.out.println("main do ");




    }


}
