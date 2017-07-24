
package ir.phgint;

import java.util.concurrent.TransferQueue;

public class Buffer {

    private int primeNumber;
    private boolean flag = true;
    public final TransferQueue<Integer> tQueue;

    public Buffer(boolean flag, TransferQueue<Integer> tQueue) {
        this.flag = flag;
        this.tQueue = tQueue;
    }

    public  boolean isFlag() {
        return flag;
    }

    public  void setFlag(boolean flag) {
        this.flag = flag;
    }

    public  void setPrimeNumber(int i) {
         primeNumber = i;
    }

    public  int getPrimeNumber() {

        return primeNumber;
    }
}

