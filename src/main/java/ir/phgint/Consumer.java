package ir.phgint;


import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {

    private final TransferQueue<Integer> tQueue;
    private boolean isRunning = true;

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Consumer(TransferQueue<Integer> tQueue) {
        this.tQueue = tQueue;

    }

    public  void run() {

        while (getIsRunning()) {
           getPrime();
        }

    }

    public void getPrime() {

        try {
            System.out.println(tQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
