package concurrent.threadpool;

import digester.model.Main;

public class ThreadLocalExample {
    public static class MyRunnable implements Runnable{

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnable = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnable);
        Thread thread2 = new Thread(sharedRunnable);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }



}
