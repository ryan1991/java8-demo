package concurrent.threadpool;

import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created on 2019-11-02 10:32.
 *
 * @author fuxiaolei2
 * @version 1.0
 * @since 1.0
 */
public final class AsyncUtil {
    private static final ExecutorService executorService = new ThreadPoolExecutor(3, 20,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5000), new ThreadPoolExecutor.CallerRunsPolicy());

    public static <T> Optional<T> getFuture(Future<T> future, long timeout, TimeUnit unit, Consumer<Exception> callback) {
        try {
            return Optional.ofNullable(future.get(timeout, unit));
        } catch (Exception e) {
            callback.accept(e);
        }
        return Optional.empty();
    }


    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        return supplyAsync(supplier, executorService);
    }


    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier, Executor executor) {
        return CompletableFuture.supplyAsync(supplier, executor);

    }


}
