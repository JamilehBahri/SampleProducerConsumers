package ir.phgint;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestPc {



    @Test
    public void pc() {
        Buffer buffer = new Buffer(true);


         Producer producer = new Producer(buffer) {
            public void setPrime(int i) {
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
             public boolean isPrimeNumber(int i) {
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

         };
        Consumer consumer1 = new Consumer(buffer) {
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
                        System.out.println(buffer.getPrimeNumber());
                    buffer.setFlag(true);
                    buffer.notify();
                }
            }

        };
        Thread thread =new Thread(consumer1);
        try {
            thread.start();
            producer.start();
            producer.join(0);
            consumer1.setIsRunning(false);
            thread.interrupt();
            thread.join(0);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
