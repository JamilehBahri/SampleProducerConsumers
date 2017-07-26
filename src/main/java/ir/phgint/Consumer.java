package ir.phgint;

import java.util.Queue;

public class Consumer implements Runnable {

    private final Queue<PrimeNumber> pQueue;

    private boolean isRunning = true;
    private Buffer buffer;

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Consumer(Queue<PrimeNumber> pQueue , Buffer buffer) {
        this.pQueue = pQueue;
        this.buffer = buffer;
    }
    public  void run() {

        while (getIsRunning()) {

              getPrime();
        }
    }

    public void getPrime() {
        if(!pQueue.isEmpty()&& !buffer.isFlag()) {
            System.out.println(pQueue.poll());
        }
    }


}
