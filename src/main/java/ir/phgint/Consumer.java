package ir.phgint;


public class Consumer implements Runnable {

    Consumer(){
        new Consumer(){

        };
    }

    private Buffer buffer;
    boolean isRunning = true;

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
           System.out.println(getPrime());
        }

    }

    public int getPrime() {

        synchronized (buffer) {
            if (buffer.isFlag()) {
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.setFlag(true);
            buffer.notify();
            return buffer.getPrimeNumber();
        }
    }


}
