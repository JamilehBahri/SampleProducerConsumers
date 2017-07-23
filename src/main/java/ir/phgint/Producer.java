package ir.phgint;


public class Producer extends Thread {

    

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }


    public void run() {

        for (int i = 1; i < 100; i++) {
            if (isPrimeNumber(i)) {
                setPrime(i);
            }

        }


    }

    public  void setPrime(int i) {
        synchronized (buffer) {
            if (!buffer.isFlag()) {

                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.setPrimeNumber(i);
            buffer.setFlag(false);
            buffer.notify();
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




