package concurrent.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class TaskExecutors {

    private static AtomicLong rejectCount = new AtomicLong(0);
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(50), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                PrintTask printTask = (PrintTask) r;
                rejectCount.addAndGet(1);
                System.out.println("##################:" + printTask.getIndex());
            }
        });



        for (int i = 0; i < 1000; i++){
            executorService.execute(new PrintTask(i));
            System.out.println(executorService);
        }

        System.out.println("rejectCount:" + rejectCount.longValue());
    }


}
