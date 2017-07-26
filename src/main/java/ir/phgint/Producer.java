package ir.phgint;


import java.util.PriorityQueue;
import java.util.Queue;


public class Producer extends Thread {

    private final Queue<PrimeNumber> pQueue;
    private Buffer buffer;



    public Producer(Queue<PrimeNumber> pQueue , Buffer buffer) {
        this.pQueue = pQueue;
        this.buffer = buffer;

    }

    public void run() {

        for (int i = 0; i < 100; i++) {
            if (isPrimeNumber(i)) {
                setPrime(i);
            }
        }
        buffer.setFlag(false);
    }

    public void setPrime(int i) {

        PrimeNumber pr = new PrimeNumber(i);
        pQueue.add(pr);
    }

    static boolean isPrimeNumber(int i) {
        int factors = 0;
        int j = 1;

        while (j <= i) {
            if (i % j == 0) {
                factors++;
            }
            j++;
        }
        return (factors == 2);
    }


}




