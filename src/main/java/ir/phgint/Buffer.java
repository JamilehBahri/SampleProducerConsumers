
package ir.phgint;

import java.util.Queue;

public class Buffer {

    public final Queue<Integer> tQueue;

    private boolean flag = true;

    public Buffer(Queue<Integer> tQueue, boolean flag) {
        this.tQueue = tQueue;
        this.flag = flag;
    }

    public  boolean isFlag() {
        return flag;
    }

    public  void setFlag(boolean flag) {
        this.flag = flag;
    }

    public  void setPrimeNumber(int i) {
        tQueue.add(i);

    }

    public  int getPrimeNumber() {

        return tQueue.poll();
    }
}

