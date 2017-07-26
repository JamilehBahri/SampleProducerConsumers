package ir.phgint;


import java.util.concurrent.TransferQueue;

public class Producer extends Thread {


    private final TransferQueue<Integer> tQueue;

    public Producer(TransferQueue<Integer> tQueue) {
        this.tQueue = tQueue;
    }

    public void run() {

        for (int i = 1; i < 100; i++) {
            if (isPrimeNumber(i)) {
                setPrime(i);
            }

        }

    }

    public void setPrime(int i) {

        try {
            tQueue.transfer(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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




