package ir.phgint;


public abstract class Consumer implements IConsumer, Runnable {
    protected Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    boolean isRunning = true;

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        while (getIsRunning()) {
            getPrime();
        }
        if (!buffer.isFlag()) {
            getPrime();
        }

    }

}
