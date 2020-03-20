package concurrent.threadpool;

public class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i< 10; i++){
            counter.add(i);
        }
    }
}
