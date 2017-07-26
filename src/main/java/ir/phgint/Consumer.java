package ir.phgint;


import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {

    private  Buffer buffer;
    private boolean isRunning = true;

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Consumer(Buffer buffer) {
        this.buffer = buffer;

    }

    public  void run() {

        while (getIsRunning()) {
           getPrime();
        }
        if(!buffer.isFlag())
            getPrime();

    }

    public void getPrime() {

        synchronized (buffer)
        {
            if (buffer.isFlag())
            {
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!buffer.isFlag())
                System.out.println(buffer.getPrimeNumber());
            buffer.setFlag(true);
            buffer.notify();
        }


    }


}
