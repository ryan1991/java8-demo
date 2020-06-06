package concurrent.threadpool;

public class ThreadGroups {
    public static void main(String[] args) {
        printDefaultThreadGroupName();
        unionCatchException();

    }

    public static void printDefaultThreadGroupName(){

        /**
         * new Thread 没有显示指定线程组，那么默认将父线程线程组设置为自己的线程组
         */
        Thread testThread = new Thread(() -> { System.out.println("testThread " +
                Thread.currentThread().getThreadGroup().getName()); System.out.println("testThread " +
                Thread.currentThread().getName());
        });
        testThread.start();
        System.out.println(" main group " + Thread.currentThread().getThreadGroup().getName());
        System.out.println(" main " + Thread.currentThread().getName());
    }

    public static void unionCatchException(){
        ThreadGroup group1 = new ThreadGroup("group1"){

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        Thread thread = new Thread(group1, () -> {
            throw new RuntimeException("测试unchecked异常");
        });
        thread.start();

    }
}
