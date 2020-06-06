package concurrent.threadpool;

import java.util.stream.IntStream;

/**
 *   Java程序中对线程所设置的优先级只给操作系统一个建议，并不一定会被采纳
 *   而真正的调用顺序，是由操作系统的线程调度算法决定的
 */
public class ThreadPriority {

    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是： %s, 优先级是：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        } }
    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        }); }

}
