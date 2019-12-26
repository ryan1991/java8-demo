package concurrent.threadpool;

public class PrintTask implements Runnable {

    private int index;

    public PrintTask(int i){
        index = i;

    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " print "+ index);
    }

    public int getIndex(){
        return index;
    }
}
