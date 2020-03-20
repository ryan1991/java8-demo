package concurrent.threadpool;

import java.util.Optional;
import java.util.concurrent.*;

public class CompletableFutures {
    private static final ExecutorService executorService = new ThreadPoolExecutor(3, 20,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5000), new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String>  future = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello";
        });

        System.out.println(future.get(100, TimeUnit.MILLISECONDS));

//
//        Optional<String> optional = AsyncUtil.getFuture(AsyncUtil.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello";
//        }), 10000,TimeUnit.MILLISECONDS, e -> {e.printStackTrace();});
//        System.out.println(optional);



    }
}
