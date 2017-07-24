package ir.phgint;


public class Consumer implements Runnable {


    private Buffer buffer;
//    private final TransferQueue<Integer> tQueue;
    boolean isRunning = true;

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Consumer( Buffer buffer) {
        this.buffer = buffer;
//        this.tQueue = tQueue;
    }

    public  void run() {

        while (getIsRunning()) {
           getPrime();
        }
        if (!buffer.isFlag()) {
            getPrime();
        }
    }

    public void getPrime() {

        synchronized (buffer) {
            if (buffer.isFlag()) {
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!buffer.isFlag())
        try {
            System.out.println(buffer.tQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            buffer.setFlag(true);
            buffer.notify();

        }
    }


}
